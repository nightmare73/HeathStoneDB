package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardRarity

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
) {
    fun toCardRarity() = CardRarity(
        id = id,
        slug = slug,
        name = name,
        craftingCost = craftingCost[0],
        craftingGoldCost = craftingCost[1],
        dustValue = dustValue[0],
        dustGoldValue = dustValue[1],
    )
}
