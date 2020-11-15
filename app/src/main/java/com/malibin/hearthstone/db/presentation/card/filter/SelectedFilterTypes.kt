package com.malibin.hearthstone.db.presentation.card.filter

import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.entity.metadata.MetaData.FilterType
import java.util.*

/**
 * Created By Malibin
 * on 11월 14, 2020
 */

class SelectedFilterTypes(
    private val values: EnumMap<FilterType, MutableList<MetaData>> = EnumMap(FilterType::class.java)
) {
    fun get(): Map<FilterType, List<MetaData>> = values

    fun get(filterType: FilterType): List<MetaData> {
        return values[filterType] ?: emptyList()
    }

    @Synchronized
    fun apply(filterType: FilterType, filterDetail: MetaData) {
        if (values[filterType] == null) {
            values[filterType] = mutableListOf()
        }
        val selectedDetails = values[filterType] ?: throw IllegalStateException()
        if (selectedDetails.contains(filterDetail)) selectedDetails.remove(filterDetail)
        else selectedDetails.add(filterDetail)
    }

    fun isEmpty(): Boolean {
        return values.all { it.value.isEmpty() }
    }

    fun toQuery(): SupportSQLiteQuery {
        if (this.isEmpty()) return SimpleSQLiteQuery("$SELECT_ALL_CARDS$ORDER_BY")
        val stringBuilder = StringBuilder(SELECT_ALL_CARDS).append("WHERE ")
        val filterQueries = values.asSequence()
            .filter { it.value.isNotEmpty() }
            .joinToString(" AND ") { filterQueryOf(it) }
        stringBuilder.append(filterQueries)
        stringBuilder.append(ORDER_BY)
        return SimpleSQLiteQuery(stringBuilder.toString())
    }

    private fun filterQueryOf(entry: Map.Entry<FilterType, List<MetaData>>): String {
        return "${entry.key.queryKey} IN(${entry.value.toCommaSeparateIds()})"
    }

    private fun List<MetaData>.toCommaSeparateIds(): String {
        return this.joinToString(",") { it.id.toString() }
    }

    companion object {
        private const val SELECT_ALL_CARDS = "SELECT * FROM Card "
        private const val ORDER_BY = "ORDER BY manaCost, name"
        private const val BASIC_HERO = 17
    }
}
