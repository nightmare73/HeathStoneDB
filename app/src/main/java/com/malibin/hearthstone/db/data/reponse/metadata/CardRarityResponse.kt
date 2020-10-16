package com.malibin.hearthstone.db.data.reponse.metadata

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class CardRarityResponse(
    val slug: String,
    val id: Int,
    val craftingCost: List<Int?>,
    val dustValue: List<Int?>,
    val name: String
)
