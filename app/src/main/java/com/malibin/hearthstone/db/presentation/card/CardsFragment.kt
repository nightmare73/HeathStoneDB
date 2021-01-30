package com.malibin.hearthstone.db.presentation.card

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.databinding.FragmentCardsBinding
import com.malibin.hearthstone.db.presentation.card.detail.CardDetailActivity
import com.malibin.hearthstone.db.presentation.utils.printLog
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
    ): View {
        val binding = FragmentCardsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = cardsViewModel
        initCardList(binding)
        return binding.root
    }

    private fun initCardList(binding: FragmentCardsBinding) {
        val cardsAdapter = CardsAdapter()
        cardsAdapter.onCardClicked = { deployCardDetailActivity(it) }
        binding.rvCards.adapter = cardsAdapter
        cardsViewModel.cards.observe(viewLifecycleOwner) {
            cardsAdapter.submitList(it)
        }
    }

    // TODO onCardClick 함수를 변수로 받고 액티비티에서 제어하게 만들자
    private fun deployCardDetailActivity(card: Card) {
        printLog(card.toString())
        val intent = Intent(requireContext(), CardDetailActivity::class.java)
        intent.putExtra(CardDetailActivity.KEY_CARD_ID, card.id)
        startActivity(intent)
    }
}
