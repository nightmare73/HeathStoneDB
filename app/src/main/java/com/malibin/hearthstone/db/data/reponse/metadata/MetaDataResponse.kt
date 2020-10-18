package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.*

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class MetaDataResponse(
    val sets: List<CardSetResponse>,
    val setGroups: List<CardSetGroup>,
    val arenaIds: List<Int>,
    val types: List<CardType>,
    val rarities: List<CardRarityResponse>,
    val classes: List<CardClass>,
    val minionTypes: List<MinionType>,
    val keywords: List<CardKeyword>,
    val cardBackCategories: List<CardBackCategory>,
)
