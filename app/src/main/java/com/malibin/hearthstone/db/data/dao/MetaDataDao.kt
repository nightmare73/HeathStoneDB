package com.malibin.hearthstone.db.data.dao

import androidx.room.*
import com.malibin.hearthstone.db.data.entity.metadata.*

/**
 * Created By Malibin
 * on 10월 19, 2020
 */

@Dao
abstract class MetaDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardSets(cardSets: List<CardSet>)

    @Query("SELECT * FROM cardset")
    abstract suspend fun getCardSets(): List<CardSet>

    @Query("DELETE FROM cardset")
    abstract suspend fun deleteCardSets()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardSetGroups(cardSetGroups: List<CardSetGroup>)

    @Query("SELECT * FROM cardsetgroup")
    abstract suspend fun getCardSetGroups(): List<CardSetGroup>

    @Query("DELETE FROM cardsetgroup")
    abstract suspend fun deleteCardSetGroups()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertArenaCards(arenaCards: List<ArenaCard>)

    @Query("SELECT * FROM arenacard")
    abstract suspend fun getCardArenaCardIds(): List<ArenaCard>

    @Query("DELETE FROM arenacard")
    abstract suspend fun deleteArenaCardIds()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardTypes(cardTypes: List<CardType>)

    @Query("SELECT * FROM cardtype")
    abstract suspend fun getCardTypes(): List<CardType>

    @Query("DELETE FROM cardtype")
    abstract suspend fun deleteCardTypes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardRarities(cardRarities: List<CardRarity>)

    @Query("SELECT * FROM cardrarity")
    abstract suspend fun getCardRarities(): List<CardRarity>

    @Query("DELETE FROM cardrarity")
    abstract suspend fun deleteCardRarities()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardClasses(cardClasses: List<CardClass>)

    @Query("SELECT * FROM cardclass")
    abstract suspend fun getCardClasses(): List<CardClass>

    @Query("DELETE FROM cardclass")
    abstract suspend fun deleteCardClasses()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertMinionTypes(minionTypes: List<MinionType>)

    @Query("SELECT * FROM miniontype")
    abstract suspend fun getMinionTypes(): List<MinionType>

    @Query("DELETE FROM miniontype")
    abstract suspend fun deleteMinionTypes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardKeywords(cardKeywords: List<CardKeyword>)

    @Query("SELECT * FROM cardkeyword")
    abstract suspend fun getCardKeywords(): List<CardKeyword>

    @Query("DELETE FROM CardKeyword")
    abstract suspend fun deleteCardKeywords()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCardBackCategories(cardBackCategories: List<CardBackCategory>)

    @Query("SELECT * FROM cardbackcategory")
    abstract suspend fun getCardBackCategories(): List<CardBackCategory>

    @Query("DELETE FROM cardbackcategory")
    abstract suspend fun deleteCardBackCategories()

    @Transaction
    suspend fun deleteAllMetaData() {
        deleteCardSets()
        deleteCardSetGroups()
        deleteArenaCardIds()
        deleteCardTypes()
        deleteCardRarities()
        deleteCardClasses()
        deleteMinionTypes()
        deleteCardKeywords()
        deleteCardBackCategories()
    }
}
