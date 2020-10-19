package com.malibin.hearthstone.db.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.malibin.hearthstone.db.data.entity.Card

/**
 * Created By Malibin
 * on 10월 19, 2020
 */

@Dao
interface CardsDao {

    @Insert
    suspend fun insertCards(cards: List<Card>)

    @Query("SELECT * FROM card")
    suspend fun getAllCards(): List<Card>

    @Query("SELECT * FROM card WHERE id = :id")
    suspend fun fetchCard(id: Int): Card?

    @Query("DELETE FROM card")
    suspend fun deleteAllCards()
}
