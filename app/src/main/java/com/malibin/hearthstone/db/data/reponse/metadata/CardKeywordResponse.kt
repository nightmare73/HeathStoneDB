package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardKeyword
import com.malibin.hearthstone.db.data.entity.metadata.MetaData

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

data class CardKeywordResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val text: String,
    val refText: String,
) {
    fun toCardKeyword() = CardKeyword(
        id = id,
        slug = slug,
        name = name,
        text = text,
        detailText = refText,
        filterType = MetaData.FilterType.KEYWORD,
    )
}
