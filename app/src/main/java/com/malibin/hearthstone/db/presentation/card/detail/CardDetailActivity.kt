package com.malibin.hearthstone.db.presentation.card.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.databinding.ActivityCardDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailActivity : AppCompatActivity() {

    private val cardDetailViewModel: CardDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView(binding)

        cardDetailViewModel.loadCard(getCardId())
    }

    private fun initView(binding: ActivityCardDetailBinding) {
        binding.lifecycleOwner = this
        binding.viewModel = cardDetailViewModel
    }

    private fun getCardId(): Int = intent.getIntExtra(KEY_CARD_ID, -1)

    companion object {
        const val KEY_CARD_ID = "KEY_CARD_ID"
    }
}
