package com.malibin.hearthstone.db.presentation.card.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.entity.metadata.MetaData.FilterType
import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

@HiltViewModel
class FilterViewModel @Inject constructor(
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

    private val _selectedDetails = MutableLiveData(SelectedFilterTypes())
    val selectedDetails: LiveData<SelectedFilterTypes>
        get() = _selectedDetails

    fun loadFilterDetailsOf(filterType: FilterType) = viewModelScope.launch {
        _isLoading.value = true
        _currentSelectedFilterType.value = filterType
        val token = blizzardAuthRepository.getAccessToken()
        _filterDetails.value = metadataRepository.getFilterMetaDataOf(filterType, token)
        _isLoading.value = false
    }

    fun applyFilterType(filterDetail: MetaData) {
        val selectedDetails = getSelectedDetails()
        selectedDetails.apply(getCurrentFilterType(), filterDetail)
        this._selectedDetails.value = selectedDetails
    }

    private fun getSelectedDetails() = _selectedDetails.value
        ?: throw IllegalStateException("selectedDetails.value cannot be null")

    fun getCurrentFilterType() = _currentSelectedFilterType.value
        ?: throw IllegalStateException("currentSelectedFilterType.value cannot be null")
}
