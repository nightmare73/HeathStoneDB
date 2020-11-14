package com.malibin.hearthstone.db.presentation.card

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.CardsRepository
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 11월 14, 2020
 */

class CardsViewModel @ViewModelInject constructor(
    private val cardsRepository: CardsRepository,
    private val blizzardAuthRepository: BlizzardAuthRepository,
) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>(emptyList())
    val cards: LiveData<List<Card>>
        get() = _cards

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun loadCards() = viewModelScope.launch {
        val accessToken = blizzardAuthRepository.getAccessToken()
        val cards = cardsRepository.getAllCards(accessToken)
        _cards.value = cards
    }
}
