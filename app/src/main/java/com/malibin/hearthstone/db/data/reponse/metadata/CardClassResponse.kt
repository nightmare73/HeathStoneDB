package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardClass

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

data class CardClassResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val cardId: Int?,
) {
    fun toCardClass() = CardClass(
        id = id,
        slug = slug,
        name = name,
        cardId = cardId,
    )
}
