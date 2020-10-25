package com.malibin.hearthstone.db.data.repository

import com.malibin.hearthstone.db.data.dao.CardsDao
import com.malibin.hearthstone.db.data.entity.Card
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 26, 2020
 */

class CardsRepository @Inject constructor(
    private val cardsDao: CardsDao,
) {
    suspend fun saveCards(cards: List<Card>) {
        cardsDao.insertCards(cards)
    }

    suspend fun deleteAllCards() {
        cardsDao.deleteAllCards()
    }

    suspend fun getAllCards(): List<Card> {
        return cardsDao.getAllCards()
    }
}
