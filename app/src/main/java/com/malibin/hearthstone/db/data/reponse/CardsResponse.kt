package com.malibin.hearthstone.db.data.reponse

import com.malibin.hearthstone.db.data.RawCard

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class CardsResponse(
    val cards: List<RawCard>,
    val cardCount: Int,
    val pageCount: Int,
    val page: Int,
) {
    fun toCards() = cards.map { it.toCard() }

    fun toBattleGroundCards() = cards.map { it.toBattleGroundCard() }
}
