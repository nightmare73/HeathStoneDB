package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardSet
import java.text.SimpleDateFormat
import java.util.*

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
) {
    fun toCardSet() = CardSet(
        id = id,
        name = name,
        slug = slug,
        releaseDate = releaseDate?.let {
            SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).parse(it)
        },
        type = type,
        collectibleCount = collectibleCount,
    )
}
