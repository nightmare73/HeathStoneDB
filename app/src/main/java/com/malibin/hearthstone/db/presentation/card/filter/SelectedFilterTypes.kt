package com.malibin.hearthstone.db.presentation.card.filter

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
}
