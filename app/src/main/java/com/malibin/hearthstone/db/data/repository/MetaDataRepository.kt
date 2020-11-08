package com.malibin.hearthstone.db.data.repository

import com.malibin.hearthstone.db.data.dao.MetaDataDao
import com.malibin.hearthstone.db.data.entity.metadata.*
import com.malibin.hearthstone.db.data.reponse.metadata.MetaDataResponse
import com.malibin.hearthstone.db.data.service.BlizzardService
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 23, 2020
 */

class MetaDataRepository @Inject constructor(
    private val metaDataDao: MetaDataDao,
    private val blizzardService: BlizzardService,
) {
    private val cachedCardSets = mutableListOf<CardSet>()
    private val cachedCardSetGroups = mutableListOf<CardSetGroup>()
    private val cachedArenaCardIds = mutableListOf<ArenaCardId>()
    private val cachedCardTypes = mutableListOf<CardType>()
    private val cachedCardRarities = mutableListOf<CardRarity>()
    private val cachedCardClasses = mutableListOf<CardClass>()
    private val cachedMinionTypes = mutableListOf<MinionType>()
    private val cachedCardKeywords = mutableListOf<CardKeyword>()
    private val cachedCardBackCategories = mutableListOf<CardBackCategory>()

    suspend fun loadAllMetaDataFromRemote(accessToken: String) {
        val metaDataResponse = blizzardService.getMetaData(accessToken)
        deleteAllMetaData()
        metaDataDao.insertAllMetaData(metaDataResponse)
        cacheAllMetaData(metaDataResponse)
    }

    private fun cacheAllMetaData(metaDataResponse: MetaDataResponse) {
        cachedCardSets.addAll(metaDataResponse.getCardSets())
        cachedCardSetGroups.addAll(metaDataResponse.getCardSetGroups())
        cachedArenaCardIds.addAll(metaDataResponse.getArenaCardIds())
        cachedCardTypes.addAll(metaDataResponse.getCardTypes())
        cachedCardRarities.addAll(metaDataResponse.getCardRarities())
        cachedCardClasses.addAll(metaDataResponse.getCardClasses())
        cachedMinionTypes.addAll(metaDataResponse.getMinionTypes())
        cachedCardKeywords.addAll(metaDataResponse.getCardKeywords())
        cachedCardBackCategories.addAll(metaDataResponse.getCardBackCategories())
    }

    suspend fun getFilterMetaDataOf(
        filterType: MetaData.FilterType,
        accessToken: String
    ): List<MetaData> {
        return when (filterType) {
            MetaData.FilterType.CARD_TYPE -> getCardTypes(accessToken)
            MetaData.FilterType.CARD_SET -> getCardSets(accessToken)
            MetaData.FilterType.RARITY -> getCardRarities(accessToken)
            MetaData.FilterType.CLASS -> getCardClasses(accessToken)
            MetaData.FilterType.MINION_TYPE -> getMinionTypes(accessToken)
            MetaData.FilterType.KEYWORD -> getCardKeywords(accessToken)
            MetaData.FilterType.COST -> emptyList()
        }
    }

    @Synchronized
    suspend fun getCardSets(accessToken: String): List<CardSet> {
        if (cachedCardSets.isEmpty()) {
            val cardSets = metaDataDao.getCardSets()
            if (cardSets.isNotEmpty()) return cardSets
                .also { cachedCardSets.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardSets
    }

    @Synchronized
    suspend fun getCardSetGroups(accessToken: String): List<CardSetGroup> {
        if (cachedCardSetGroups.isEmpty()) {
            val cardSetGroups = metaDataDao.getCardSetGroups()
            if (cardSetGroups.isNotEmpty()) return cardSetGroups
                .also { cachedCardSetGroups.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardSetGroups
    }

    @Synchronized
    suspend fun getArenaCardIds(accessToken: String): List<ArenaCardId> {
        if (cachedArenaCardIds.isEmpty()) {
            val cardArenaCardIds = metaDataDao.getCardArenaCardIds()
            if (cardArenaCardIds.isNotEmpty()) return cardArenaCardIds
                .also { cachedArenaCardIds.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedArenaCardIds
    }

    @Synchronized
    suspend fun getCardTypes(accessToken: String): List<CardType> {
        if (cachedCardTypes.isEmpty()) {
            val cardTypes = metaDataDao.getCardTypes()
            if (cardTypes.isNotEmpty()) return cardTypes
                .also { cachedCardTypes.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardTypes
    }

    @Synchronized
    suspend fun getCardRarities(accessToken: String): List<CardRarity> {
        if (cachedCardRarities.isEmpty()) {
            val cardRarities = metaDataDao.getCardRarities()
            if (cardRarities.isNotEmpty()) return cardRarities
                .also { cachedCardRarities.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardRarities
    }

    @Synchronized
    suspend fun getCardClasses(accessToken: String): List<CardClass> {
        if (cachedCardClasses.isEmpty()) {
            val cardClasses = metaDataDao.getCardClasses()
            if (cardClasses.isNotEmpty()) return cardClasses
                .also { cachedCardClasses.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardClasses
    }

    @Synchronized
    suspend fun getMinionTypes(accessToken: String): List<MinionType> {
        if (cachedMinionTypes.isEmpty()) {
            val minionTypes = metaDataDao.getMinionTypes()
            if (minionTypes.isNotEmpty()) return minionTypes
                .also { cachedMinionTypes.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedMinionTypes
    }

    @Synchronized
    suspend fun getCardKeywords(accessToken: String): List<CardKeyword> {
        if (cachedCardKeywords.isEmpty()) {
            val cardKeywords = metaDataDao.getCardKeywords()
            if (cardKeywords.isNotEmpty()) return cardKeywords
                .also { cachedCardKeywords.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardKeywords
    }

    @Synchronized
    suspend fun getCardBackCategories(accessToken: String): List<CardBackCategory> {
        if (cachedCardBackCategories.isEmpty()) {
            val cardBackCategories = metaDataDao.getCardBackCategories()
            if (cardBackCategories.isNotEmpty()) return cardBackCategories
                .also { cachedCardBackCategories.addAll(it) }
            loadAllMetaDataFromRemote(accessToken)
        }
        return cachedCardBackCategories
    }

    suspend fun deleteAllMetaData() {
        metaDataDao.deleteAllMetaData()
    }
}
