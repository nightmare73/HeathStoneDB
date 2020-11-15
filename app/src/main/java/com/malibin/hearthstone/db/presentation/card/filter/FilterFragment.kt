package com.malibin.hearthstone.db.presentation.card.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.databinding.FragmentFilterBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created By Malibin
 * on 11월 06, 2020
 */

@AndroidEntryPoint
class FilterFragment : Fragment() {
    private val filterViewModel: FilterViewModel by activityViewModels()
    private var filterChipGroup: FilterChipGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = filterViewModel
        initFilterList(binding)
        initFilterDetails(binding)
        return binding.root
    }

    private fun initFilterList(binding: FragmentFilterBinding) {
        val dividerDecoration =
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        val filterAdapter =
            FilterAdapter(filterViewModel.currentSelectedFilterType, viewLifecycleOwner)
        filterAdapter.setOnFilterTypeClickListener { onFilterTypeClick(it) }
        binding.rvFilterItems.addItemDecoration(dividerDecoration)
        binding.rvFilterItems.adapter = filterAdapter
    }

    private fun onFilterTypeClick(filterType: MetaData.FilterType) {
        filterViewModel.loadFilterDetailsOf(filterType)
    }

    private fun initFilterDetails(binding: FragmentFilterBinding) {
        filterChipGroup = FilterChipGroup(binding.cgFilterDetails)
        requireFilterChipGroup().setOnClickListener(this::onChipClick)
        filterViewModel.filterDetails.observe(viewLifecycleOwner) {
            val filterType = filterViewModel.getCurrentFilterType()
            requireFilterChipGroup().refresh(filterType, it)
        }
    }

    private fun onChipClick(view: View, filterDetail: MetaData) {
        view.isSelected = !view.isSelected
        filterViewModel.applyFilterType(filterDetail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFilterTypeClick(MetaData.FilterType.CARD_TYPE)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        requireFilterChipGroup().destroy()
        filterChipGroup = null
    }

    private fun requireFilterChipGroup() = filterChipGroup
        ?: throw IllegalStateException("FilterChipGroup is not attached to Fragment")
}
