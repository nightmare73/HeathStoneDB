package com.malibin.hearthstone.db.data.reponse.metadata

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class CardSetGroupResponse(
    val slug: String,
    val cardSets: List<String>,
    val name: String,
    val year: Int?,
    val standard: Boolean?,
)
