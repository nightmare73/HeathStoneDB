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
    override val id: Int,
    override val slug: String,
    override val name: String,
    val releaseDate: Date?,
    val type: String,
    val collectibleCount: Int,
) : MetaData
