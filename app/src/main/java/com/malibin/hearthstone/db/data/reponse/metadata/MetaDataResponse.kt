package com.malibin.hearthstone.db.data.reponse.metadata

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class MetaDataResponse(
    val sets: List<CardSetResponse>,
    val setGroups: List<CardSetGroupResponse>,
    val arenaIds: List<Int>,
    val types: List<CardTypeResponse>,
    val rarities: List<CardRarityResponse>,
    val classes: List<CardClassResponse>,
    val minionTypes: List<MinionTypeResponse>,
    val keywords: List<CardKeywordResponse>,
    val cardBackCategories: List<CardBackCategoryResponse>,
)
