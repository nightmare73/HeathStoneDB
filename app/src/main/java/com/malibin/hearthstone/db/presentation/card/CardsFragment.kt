package com.malibin.hearthstone.db.presentation.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.malibin.hearthstone.db.databinding.FragmentCardsBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

@AndroidEntryPoint
class CardsFragment : Fragment() {
    private val cardsViewModel: CardsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCardsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = cardsViewModel
        initCardList(binding)
        return binding.root
    }

    private fun initCardList(binding: FragmentCardsBinding) {
        val cardsAdapter = CardsAdapter()
        binding.rvCards.adapter = cardsAdapter
        cardsViewModel.cards.observe(viewLifecycleOwner) {
            cardsAdapter.submitList(it)
        }
    }
}
