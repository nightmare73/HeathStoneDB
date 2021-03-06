package com.malibin.hearthstone.db.presentation.initial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 26, 2020
 */

@HiltViewModel
class InitialDataViewModel @Inject constructor(
    private val cardsRepository: CardsRepository,
    private val metaDataRepository: MetaDataRepository,
) : ViewModel() {

    private val _isMetaDataLoadFinished = MutableLiveData(false)
    val isMetaDataLoadFinished: LiveData<Boolean>
        get() = _isMetaDataLoadFinished

    private val _isCardsLoadFinished = MutableLiveData(false)
    val isCardsLoadFinished: LiveData<Boolean>
        get() = _isCardsLoadFinished

    fun load() = viewModelScope.launch {
        loadMetaData()
        loadCards()
    }

    private suspend fun loadMetaData() {
        _isMetaDataLoadFinished.value = false
        metaDataRepository.loadAllMetaDataFromRemote()
        _isMetaDataLoadFinished.value = true
    }

    private suspend fun loadCards() {
        _isCardsLoadFinished.value = false
        cardsRepository.loadAllCardsFromRemote()
        _isCardsLoadFinished.value = true
    }

    suspend fun deleteAllTempFunction() {
        cardsRepository.deleteAllCards()
        metaDataRepository.deleteAllMetaData()
    }
}
