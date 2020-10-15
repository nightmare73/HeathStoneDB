package com.malibin.hearthstone.db.data

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class RawBattleGround(
    val tier: Int,
    val hero: Boolean,
    val upgradeId: Int,
    val image: String,
    val imageGold: String,
)
