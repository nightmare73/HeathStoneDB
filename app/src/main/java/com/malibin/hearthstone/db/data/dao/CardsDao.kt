package com.malibin.hearthstone.db.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malibin.hearthstone.db.data.entity.Card

/**
 * Created By Malibin
 * on 10월 19, 2020
 */

// TODO: 아레나 카드 한방에 뽑아내는 기능
// TODO: Constructed Or BattleGround Card만 가져오는 기능

@Dao
interface CardsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cards: List<Card>)

    @Query("SELECT * FROM card")
    suspend fun getAllCards(): List<Card>

    @Query("SELECT * FROM card WHERE id = :id")
    suspend fun fetchCard(id: Int): Card?

    @Query("DELETE FROM card")
    suspend fun deleteAllCards()
}
