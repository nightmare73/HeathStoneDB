package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardType

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

data class CardTypeResponse(
    val id: Int,
    val slug: String,
    val name: String,
) {
    fun toCardType() = CardType(
        id = id,
        slug = slug,
        name = name,
    )
}
