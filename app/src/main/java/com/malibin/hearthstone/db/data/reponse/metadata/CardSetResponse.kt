package com.malibin.hearthstone.db.data.reponse.metadata

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class CardSetResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val releaseDate: String?,
    val type: String,
    val collectibleCount: Int,
    val collectibleRevealedCount: Int,
    val nonCollectibleCount: Int,
    val nonCollectibleRevealedCount: Int
)
