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
    override val id: Int,
    override val slug: String,
    override val name: String,
    val cardId: Int? = null,
) : MetaData
