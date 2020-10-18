package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class MinionType(
    @PrimaryKey
    val id: Int,
    val slug: String,
    val name: String,
)
