package com.malibin.hearthstone.db.data.reponse.metadata

import com.malibin.hearthstone.db.data.entity.metadata.*

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

data class MetaDataResponse(
    private val sets: List<CardSetResponse>,
    private val setGroups: List<CardSetGroup>,
    private val arenaIds: List<Int>,
    private val types: List<CardType>,
    private val rarities: List<CardRarityResponse>,
    private val classes: List<CardClass>,
    private val minionTypes: List<MinionType>,
    private val keywords: List<CardKeyword>,
    private val cardBackCategories: List<CardBackCategory>,
) {
    fun getCardSets(): List<CardSet> = sets.map { it.toCardSet() }

    fun getCardSetGroups(): List<CardSetGroup> = setGroups

    fun getArenaCardIds(): List<ArenaCardId> = arenaIds.map { ArenaCardId(it) }

    fun getCardTypes(): List<CardType> = types

    fun getCardRarities(): List<CardRarity> = rarities.map { it.toCardRarity() }

    fun getCardClasses(): List<CardClass> = classes

    fun getMinionTypes(): List<MinionType> = minionTypes

    fun getCardKeywords(): List<CardKeyword> = keywords

    fun getCardBackCategories(): List<CardBackCategory> = cardBackCategories
}
