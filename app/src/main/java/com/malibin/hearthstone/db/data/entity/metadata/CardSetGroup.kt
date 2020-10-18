package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class CardSetGroup(
    @PrimaryKey
    val slug: String,
    val cardSets: List<String>,
    val name: String,
    val year: Int?,
    val standard: Boolean?,
)
