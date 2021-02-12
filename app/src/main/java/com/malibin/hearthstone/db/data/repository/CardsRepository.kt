package com.malibin.hearthstone.db.data.repository

import com.malibin.hearthstone.db.data.dao.CardsDao
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.service.BlizzardService
import com.malibin.hearthstone.db.presentation.card.filter.SelectedFilterTypes
import com.malibin.hearthstone.db.presentation.utils.printLog
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 26, 2020
 */

// TODO: 나중에 카드 리스트 페이징도 해보자
class CardsRepository @Inject constructor(
    private val cardsDao: CardsDao,
    private val blizzardService: BlizzardService,
) {
    suspend fun getCards(selectedFilterTypes: SelectedFilterTypes): List<Card> {
        val cards = cardsDao.getCards(selectedFilterTypes.toQuery())
        if (cards.isNotEmpty()) return cards
        loadAllCardsFromRemote()
        return cardsDao.getCards(selectedFilterTypes.toQuery())
    }

    suspend fun loadAllCardsFromRemote() {
        deleteAllCards()
        val firstCardsResponse = blizzardService.getCards()
        saveCards(firstCardsResponse.toCards())
        (2..firstCardsResponse.pageCount).forEach { loadCardsPageOf(it) }
    }

    suspend fun deleteAllCards() {
        cardsDao.deleteAllCards()
    }

    private suspend fun saveCards(cards: List<Card>) {
        cardsDao.insertCards(cards)
    }

    private suspend fun loadCardsPageOf(page: Int) {
        val cardsResponse = blizzardService.getCards(page = page)
        saveCards(cardsResponse.toCards())
        printLog("card page of $page loaded")
    }
}
