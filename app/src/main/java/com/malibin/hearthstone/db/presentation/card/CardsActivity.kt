package com.malibin.hearthstone.db.presentation.card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.hearthstone.db.R
import com.malibin.hearthstone.db.presentation.card.filter.FilterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CardsFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.zone_filter, FilterFragment())
            .commit()
    }
}
