package com.malibin.hearthstone.db.presentation.card.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.presentation.utils.printLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 1월 30, 2021
 */

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val cardsRepository: CardsRepository,
) : ViewModel() {
    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card> = _card

    fun loadCard(cardId: Int) = viewModelScope.launch {
        val card = cardsRepository.getCard(cardId).also { printLog("$card") }
        _card.postValue(card)
    }
}
