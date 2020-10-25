package com.malibin.hearthstone.db.presentation.initial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.service.BlizzardService
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 26, 2020
 */

class InitialDataViewModel @Inject constructor(
    private val oAuthService: BlizzardOAuthService,
    private val blizzardService: BlizzardService,
    private val metaDataRepository: MetaDataRepository,
    private val cardsRepository: CardsRepository,
) : ViewModel() {

    private val _isMetaDataLoadFinished = MutableLiveData(false)
    val isMetaDataLoadFinished: LiveData<Boolean>
        get() = _isMetaDataLoadFinished

    private val _isCardsLoadFinished = MutableLiveData(false)
    val isCardsLoadFinished: LiveData<Boolean>
        get() = _isCardsLoadFinished

    fun load() = viewModelScope.launch {
        val blizzardToken = oAuthService.requestOAuthToken().accessToken
        loadMetaData(blizzardToken)
        loadCards(blizzardToken)
    }

    private suspend fun loadMetaData(token: String) {
        val metaDataResponse = blizzardService.getMetaData(token)
        metaDataRepository.saveMetaData(metaDataResponse)
        _isMetaDataLoadFinished.value = true
    }

    private suspend fun loadCards(token: String) {
        val cardsResponse = blizzardService.getCards(token)
        cardsRepository.saveCards(cardsResponse.toCards())
        (2..cardsResponse.pageCount).forEach { loadCardsPageOf(it, token) }
        _isCardsLoadFinished.value = true
    }

    private suspend fun loadCardsPageOf(page: Int, token: String) {
        val cardsResponse = blizzardService.getCards(accessToken = token, page = page)
        cardsRepository.saveCards(cardsResponse.toCards())
    }
}
