package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 18, 2020
 */

@Entity
data class CardRarity(
    @PrimaryKey
    val id: Int,
    val slug: String,
    val name: String,
    val craftingCost: Int?,
    val craftingGoldCost: Int?,
    val dustValue: Int?,
    val dustGoldValue: Int?,
)
