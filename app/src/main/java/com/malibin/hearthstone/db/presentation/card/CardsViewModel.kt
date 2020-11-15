package com.malibin.hearthstone.db.presentation.card

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.presentation.card.filter.SelectedFilterTypes
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

    fun loadCards(selectedFilterTypes: SelectedFilterTypes) = viewModelScope.launch {
        _isLoading.value = true
        val accessToken = blizzardAuthRepository.getAccessToken()
        val cards = cardsRepository.getCards(accessToken, selectedFilterTypes)
        _cards.value = cards
        _isLoading.value = false
    }
}
