package com.malibin.hearthstone.db.presentation.card.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.repository.CardsRepository

/**
 * Created By Malibin
 * on 1월 30, 2021
 */

class CardDetailViewModel @ViewModelInject constructor(
    private val cardsRepository: CardsRepository,
) {
    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card> = _card

    fun loadCard(cardId: Int) {

    }
}
