package com.malibin.hearthstone.db.data.repository

import com.malibin.hearthstone.db.data.dao.MetaDataDao
import com.malibin.hearthstone.db.data.entity.metadata.*
import com.malibin.hearthstone.db.data.reponse.metadata.MetaDataResponse
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 23, 2020
 */

class MetaDataRepository @Inject constructor(
    private val metaDataDao: MetaDataDao,
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

    suspend fun saveMetaData(metaDataResponse: MetaDataResponse) {
        deleteAllMetaData()
        metaDataDao.insertAllMetaData(metaDataResponse)
    }

    suspend fun deleteAllMetaData() {
        metaDataDao.deleteAllMetaData()
    }

    suspend fun getCardSets(): List<CardSet> {
        if (cachedCardSets.isEmpty()) {
            return metaDataDao.getCardSets()
                .also { cachedCardSets.addAll(it) }
        }
        return cachedCardSets
    }

    suspend fun getCardSetGroups(): List<CardSetGroup> {
        if (cachedCardSetGroups.isEmpty()) {
            return metaDataDao.getCardSetGroups()
                .also { cachedCardSetGroups.addAll(it) }
        }
        return cachedCardSetGroups
    }

    suspend fun getArenaCardIds(): List<ArenaCardId> {
        if (cachedArenaCardIds.isEmpty()) {
            return metaDataDao.getCardArenaCardIds()
                .also { cachedArenaCardIds.addAll(it) }
        }
        return cachedArenaCardIds
    }

    suspend fun getCardTypes(): List<CardType> {
        if (cachedCardTypes.isEmpty()) {
            return metaDataDao.getCardTypes()
                .also { cachedCardTypes.addAll(it) }
        }
        return cachedCardTypes
    }

    suspend fun getCardRarities(): List<CardRarity> {
        if (cachedCardRarities.isEmpty()) {
            return metaDataDao.getCardRarities()
                .also { cachedCardRarities.addAll(it) }
        }
        return cachedCardRarities
    }

    suspend fun getCardClasses(): List<CardClass> {
        if (cachedCardClasses.isEmpty()) {
            return metaDataDao.getCardClasses()
                .also { cachedCardClasses.addAll(it) }
        }
        return cachedCardClasses
    }

    suspend fun getMinionTypes(): List<MinionType> {
        if (cachedMinionTypes.isEmpty()) {
            return metaDataDao.getMinionTypes()
                .also { cachedMinionTypes.addAll(it) }
        }
        return cachedMinionTypes
    }

    suspend fun getCardKeywords(): List<CardKeyword> {
        if (cachedCardKeywords.isEmpty()) {
            return metaDataDao.getCardKeywords()
                .also { cachedCardKeywords.addAll(it) }
        }
        return cachedCardKeywords
    }

    suspend fun getCardBackCategories(): List<CardBackCategory> {
        if (cachedCardBackCategories.isEmpty()) {
            return metaDataDao.getCardBackCategories()
                .also { cachedCardBackCategories.addAll(it) }
        }
        return cachedCardBackCategories
    }
}
