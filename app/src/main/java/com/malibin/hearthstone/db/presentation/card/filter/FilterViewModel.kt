package com.malibin.hearthstone.db.presentation.card.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.entity.metadata.MetaData.FilterType
import com.malibin.hearthstone.db.data.entity.metadata.MetaData.FilterType.*
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

class FilterViewModel @Inject constructor(
    private val metadataRepository: MetaDataRepository,
    private val blizzardAuthRepository: BlizzardAuthRepository,
) : ViewModel() {

    private val _filterDetails = MutableLiveData<List<MetaData>>()
    val filterDetails: LiveData<List<MetaData>>
        get() = _filterDetails

    fun loadFilterDetailsOf(filterType: FilterType) = viewModelScope.launch {
        val token = blizzardAuthRepository.getAccessToken()
        when (filterType) {
            CARD_TYPE -> _filterDetails.value = metadataRepository.getCardTypes(token)
            CARD_SET -> _filterDetails.value = metadataRepository.getCardSets(token)
            RARITY -> _filterDetails.value = metadataRepository.getCardRarities(token)
            CLASS -> _filterDetails.value = metadataRepository.getCardClasses(token)
            MINION_TYPE -> _filterDetails.value = metadataRepository.getMinionTypes(token)
            KEYWORD -> _filterDetails.value = metadataRepository.getCardKeywords(token)
            COST -> {
            }
        }
    }
}
