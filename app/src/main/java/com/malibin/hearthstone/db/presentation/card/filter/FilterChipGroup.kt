package com.malibin.hearthstone.db.presentation.card.filter

import android.view.LayoutInflater
import android.view.View
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.databinding.ChipFilterBinding

/**
 * Created By Malibin
 * on 11월 08, 2020
 */

class FilterChipGroup(
    private val chipGroup: ChipGroup,
) {
    private val chips = mutableMapOf<MetaData.FilterType, List<Chip>>()

    private var filterChipClickListener: FilterChipClickListener? = null

    fun refresh(filterType: MetaData.FilterType, filterDetails: List<MetaData>) {
        if (chips[filterType] == null) {
            chips[filterType] = createFilterDetailChips(filterDetails)
        }
        chipGroup.removeAllViews()
        chips[filterType]?.forEach { chipGroup.addView(it) }
    }

    private fun createFilterDetailChips(
        filterDetails: List<MetaData>
    ): List<Chip> {
        return filterDetails.map { createChip(it) }
    }

    private fun createChip(filterDetail: MetaData): Chip {
        val layoutInflater = LayoutInflater.from(chipGroup.context)
        val binding = ChipFilterBinding.inflate(layoutInflater, null, false)
        binding.filterDetail = filterDetail
        binding.clickListener = filterChipClickListener
        return binding.root as Chip
    }

    fun setOnClickListener(l: FilterChipClickListener) {
        this.filterChipClickListener = l
    }

    fun destroy() {
        chips.clear()
        filterChipClickListener = null
        chipGroup.removeAllViews()
    }

    fun interface FilterChipClickListener {
        fun onChipClick(view: View, filterDetail: MetaData)
    }
}
