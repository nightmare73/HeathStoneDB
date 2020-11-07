package com.malibin.hearthstone.db.presentation.card.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.malibin.hearthstone.db.data.repository.MetaDataRepository
import com.malibin.hearthstone.db.databinding.FragmentFilterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created By Malibin
 * on 11월 06, 2020
 */

@AndroidEntryPoint
class FilterFragment : Fragment() {

    @Inject
    lateinit var metadataRepository: MetaDataRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
