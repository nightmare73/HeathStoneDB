package com.malibin.hearthstone.db.data.reponse.metadata

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class CardClassResponse(
    val slug: String,
    val id: Int,
    val name: String,
    val cardId: Int?
)
