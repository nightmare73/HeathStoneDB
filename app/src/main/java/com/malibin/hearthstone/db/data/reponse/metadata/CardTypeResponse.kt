package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.CardType
import com.malibin.hearthstone.db.data.entity.metadata.MetaData

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
        filterType = MetaData.FilterType.CARD_TYPE,
    )
}
