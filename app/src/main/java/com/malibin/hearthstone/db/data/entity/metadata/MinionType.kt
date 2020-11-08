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
) : MetaData

//    {
//      "slug": "murloc",
//      "id": 14,
//      "name": "멀록"
//    },
//    {
//      "slug": "demon",
//      "id": 15,
//      "name": "악마"
//    },
//    {
//      "slug": "mech",
//      "id": 17,
//      "name": "기계"
//    },
