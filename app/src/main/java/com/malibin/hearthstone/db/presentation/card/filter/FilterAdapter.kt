package com.malibin.hearthstone.db.presentation.card.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malibin.hearthstone.db.data.entity.metadata.MetaData
import com.malibin.hearthstone.db.databinding.ItemFilterBinding

/**
 * Created By Malibin
 * on 11월 07, 2020
 */

class FilterAdapter(
    private val filterTypes: List<MetaData.FilterType> = MetaData.FilterType.values().toList()
) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var filterTypeClickListener: FilterTypeClickListener? = null

    override fun getItemCount(): Int = filterTypes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFilterBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filterType = filterTypes[position]
        holder.bind(filterType)
    }

    fun setOnFilterTypeClickListener(listener: FilterTypeClickListener) {
        this.filterTypeClickListener = listener
    }

    inner class ViewHolder(
        private val binding: ItemFilterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(filterType: MetaData.FilterType) {
            binding.filterType = filterType
            binding.clickListener = filterTypeClickListener
        }
    }

    fun interface FilterTypeClickListener {
        fun onFilterTypeClick(filterType: MetaData.FilterType)
    }
}
