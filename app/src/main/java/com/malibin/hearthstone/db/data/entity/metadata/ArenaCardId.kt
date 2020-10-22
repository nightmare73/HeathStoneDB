package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 17, 2020
 */

@Entity
data class ArenaCardId(
    @PrimaryKey
    val id: Int,
)
