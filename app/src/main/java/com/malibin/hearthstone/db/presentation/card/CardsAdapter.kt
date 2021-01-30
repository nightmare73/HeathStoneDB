package com.malibin.hearthstone.db.presentation.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.databinding.ItemCardBinding

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

class CardsAdapter : ListAdapter<Card, CardsAdapter.ViewHolder>(DiffCallback()) {

    var onCardClicked: ((Card) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card)
    }

    inner class ViewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            binding.card = card
            binding.imgCard.setOnClickListener { onCardClicked?.invoke(card) }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }
    }
}
