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
    override val id: Int,
    override val slug: String,
    override val name: String,
    override val filterType: MetaData.FilterType = MetaData.FilterType.MINION_TYPE,
) : MetaData, Filterable
