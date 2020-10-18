package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created By Malibin
 * on 10월 17, 2020
 */

@Entity
data class CardSet(
    @PrimaryKey
    val id: Int,
    val name: String,
    val slug: String,
    val releaseDate: Date?,
    val type: String,
    val collectibleCount: Int,
)
