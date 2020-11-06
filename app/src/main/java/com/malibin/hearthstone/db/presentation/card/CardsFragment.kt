package com.malibin.hearthstone.db.presentation.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.repository.CardsRepository
import com.malibin.hearthstone.db.databinding.FragmentCardsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private val cardsAdapter = CardsAdapter()

    @Inject
    lateinit var repository: CardsRepository

    private val liveData = MutableLiveData<List<Card>>(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCardsBinding.inflate(inflater, container, false)
        binding.rvCards.adapter = cardsAdapter
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            liveData.postValue(repository.getAllCards(""))
        }

        liveData.observe(viewLifecycleOwner) {
            cardsAdapter.submitList(it)
        }
    }
}
