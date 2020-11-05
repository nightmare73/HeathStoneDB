package com.malibin.hearthstone.db.presentation.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.malibin.hearthstone.db.databinding.FragmentCardsBinding

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

class CardsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
