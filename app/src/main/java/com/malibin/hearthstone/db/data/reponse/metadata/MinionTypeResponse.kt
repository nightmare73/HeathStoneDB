package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.entity.metadata.MinionType

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

data class MinionTypeResponse(
    val id: Int,
    val slug: String,
    val name: String,
) {
    fun toMinionType() = MinionType(
        id = id,
        slug = slug,
        name = name,
        filterType = MetaData.FilterType.MINION_TYPE,
    )
}
