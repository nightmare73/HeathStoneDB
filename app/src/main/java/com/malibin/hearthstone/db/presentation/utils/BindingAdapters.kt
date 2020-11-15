package com.malibin.hearthstone.db.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.malibin.hearthstone.db.config.GlideApp

/**
 * Created By Malibin
 * on 11월 05, 2020
 */

@BindingAdapter("imageUrl")
fun bindingImageUrl(view: ImageView, imageUrl: String?) {
    GlideApp.with(view)
        .load(imageUrl)
//        .placeholder(R.drawable.loading)
        .into(view)
}
