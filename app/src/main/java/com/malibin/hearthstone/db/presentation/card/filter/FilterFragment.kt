package com.malibin.hearthstone.db.presentation.card.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import com.malibin.hearthstone.db.databinding.FragmentFilterBinding
import com.malibin.hearthstone.db.presentation.utils.printLog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created By Malibin
 * on 11월 06, 2020
 */

@AndroidEntryPoint
class FilterFragment : Fragment() {

    private val filterViewModel: FilterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = requireActivity()
        initFilterList(binding)
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
}
