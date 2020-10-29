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

class InitialDataViewModel @ViewModelInject constructor(
    private val cardsRepository: CardsRepository,
    private val metaDataRepository: MetaDataRepository,
    private val blizzardAuthRepository: BlizzardAuthRepository,
) : ViewModel() {

    private val _isMetaDataLoadFinished = MutableLiveData(false)
    val isMetaDataLoadFinished: LiveData<Boolean>
        get() = _isMetaDataLoadFinished

    private val _isCardsLoadFinished = MutableLiveData(false)
    val isCardsLoadFinished: LiveData<Boolean>
        get() = _isCardsLoadFinished

    fun load() = viewModelScope.launch {
        val blizzardAccessToken = blizzardAuthRepository.getAccessToken()
        loadMetaData(blizzardAccessToken)
        loadCards(blizzardAccessToken)
    }

    private suspend fun loadMetaData(accessToken: String) {
        _isMetaDataLoadFinished.value = false
        metaDataRepository.loadAllMetaDataFromRemote(accessToken)
        _isMetaDataLoadFinished.value = true
    }

    private suspend fun loadCards(accessToken: String) {
        _isCardsLoadFinished.value = false
        cardsRepository.loadAllCardsFromRemote(accessToken)
        _isCardsLoadFinished.value = true
    }

    suspend fun deleteAllTempFunction() {
        cardsRepository.deleteAllCards()
        metaDataRepository.deleteAllMetaData()
    }
}
