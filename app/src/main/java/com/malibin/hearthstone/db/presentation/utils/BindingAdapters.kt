package com.malibin.hearthstone.db.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

@BindingAdapter("imageUrl")
fun bindingImageUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
//        .placeholder(R.drawable.loading)
        .into(view)
}
