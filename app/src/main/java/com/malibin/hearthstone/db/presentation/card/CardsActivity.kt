package com.malibin.hearthstone.db.presentation.card

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.R
import com.malibin.hearthstone.db.presentation.card.filter.FilterFragment
import com.malibin.hearthstone.db.presentation.card.filter.FilterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsActivity : AppCompatActivity() {

    private val filterViewModel: FilterViewModel by viewModels()
    private val cardsViewModel: CardsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CardsFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.zone_filter, FilterFragment())
            .commit()

        filterViewModel.selectedDetails.observe(this) {
            cardsViewModel.loadCards(it)
        }
    }
}
