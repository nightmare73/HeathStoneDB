package com.malibin.hearthstone.db.presentation.initial

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import com.malibin.hearthstone.db.data.service.BlizzardService
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 10월 26, 2020
 */

// TODO: BlizzardService를 Repository안에 집어넣는게 더 뽐새가 좋아보인다.
// 리모트/로컬 데이터소스 레이어 추가는 안하더라도 Repository 레이어 내에 넣는게 더 나을듯.

class InitialDataViewModel @ViewModelInject constructor(
    private val blizzardAuthRepository: BlizzardAuthRepository,
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
        val blizzardToken = blizzardAuthRepository.getAccessToken()
        loadMetaData(blizzardToken)
        loadCards(blizzardToken)
    }

    private suspend fun loadMetaData(token: String) {
        _isMetaDataLoadFinished.value = false
        metaDataRepository.loadAllMetaDataFromRemote(token)
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
