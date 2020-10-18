package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class CardKeyword(
    @PrimaryKey
    val id: Int,
    val slug: String,
    val name: String,
    val text: String,
    @SerializedName("refText")
    val detailText: String,
)
