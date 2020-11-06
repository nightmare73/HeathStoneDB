package com.malibin.hearthstone.db.data.db

import androidx.room.TypeConverter
import java.util.*

/**
 * Created By Malibin
 * on 10월 18, 2020
 */

class TypeConverter {
    @TypeConverter
    fun toDate(milliseconds: Long?): Date? = milliseconds?.let { Date(it) }

    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.time

    @TypeConverter
    fun toListInt(rawString: String): List<Int> {
        return if (rawString.isBlank()) emptyList()
        else rawString.split(DELIMITER).map(String::toInt)
    }

    @TypeConverter
    fun fromListInt(intList: List<Int>): String = intList.joinToString(DELIMITER)

    @TypeConverter
    fun toListString(rawString: String): List<String> {
        return if (rawString.isBlank()) emptyList()
        else rawString.split(DELIMITER)
    }

    @TypeConverter
    fun fromListString(stringList: List<String>): String = stringList.joinToString(DELIMITER)

    companion object {
        private const val DELIMITER = "\t"
    }
}
