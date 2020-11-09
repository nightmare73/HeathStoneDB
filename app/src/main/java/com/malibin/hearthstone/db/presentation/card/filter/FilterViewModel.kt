package com.malibin.hearthstone.db.presentation.card.filter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.entity.metadata.MetaData.FilterType
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import com.malibin.hearthstone.db.presentation.utils.printLog
import kotlinx.coroutines.launch
import java.util.EnumMap

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

class FilterViewModel @ViewModelInject constructor(
    private val metadataRepository: MetaDataRepository,
    private val blizzardAuthRepository: BlizzardAuthRepository,
) : ViewModel() {

    private val _currentSelectedFilterType = MutableLiveData<FilterType>()
    val currentSelectedFilterType: LiveData<FilterType>
        get() = _currentSelectedFilterType

    private val _filterDetails = MutableLiveData<List<MetaData>>()
    val filterDetails: LiveData<List<MetaData>>
        get() = _filterDetails

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val selectedDetails = EnumMap<FilterType, MutableList<MetaData>>(FilterType::class.java)

    fun loadFilterDetailsOf(filterType: FilterType) = viewModelScope.launch {
        _isLoading.value = true
        _currentSelectedFilterType.value = filterType
        val token = blizzardAuthRepository.getAccessToken()
        _filterDetails.value = metadataRepository.getFilterMetaDataOf(filterType, token)
        _isLoading.value = false
    }

    fun applyFilterType(filterDetail: MetaData) {
        val filterType = getCurrentFilterType()
        if (selectedDetails[filterType] == null) {
            selectedDetails[filterType] = mutableListOf()
        }
        val selectedDetails = selectedDetails[filterType] ?: throw IllegalStateException()
        if (selectedDetails.contains(filterDetail)) selectedDetails.remove(filterDetail)
        else selectedDetails.add(filterDetail)
        printLog(this.selectedDetails.toString())
    }

    private fun getCurrentFilterType() = _currentSelectedFilterType.value
        ?: throw IllegalStateException("currentSelectedFilterType.value cannot be null")
}
