package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class CardClass(
    @PrimaryKey
    val slug: String,
    val id: Int,
    val name: String,
    val cardId: Int? = null,
)
