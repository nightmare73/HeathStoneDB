package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 18, 2020
 */

@Entity
data class CardRarity(
    @PrimaryKey
    override val id: Int,
    override val slug: String,
    override val name: String,
    val craftingCost: Int?,
    val craftingGoldCost: Int?,
    val dustValue: Int?,
    val dustGoldValue: Int?,
) : MetaData

//    {
//      "slug": "common",
//      "id": 1,
//      "craftingCost": [50, 400],
//      "dustValue": [5, 50],
//      "name": "일반"
//    },
//    {
//      "slug": "free",
//      "id": 2,
//      "craftingCost": [null, null],
//      "dustValue": [null, null],
//      "name": "무료"
//    },
