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
    override val id: Int,
    override val slug: String,
    override val name: String,
    val text: String,
    @SerializedName("refText")
    val detailText: String,
) : MetaData

//    {
//      "id": 2,
//      "slug": "spellpower",
//      "name": "주문 공격력",
//      "refText": "주문 카드가 추가 피해를 줍니다.",
//      "text": "주문 카드가 의 추가 피해를 줍니다."
//    },
//    {
//      "id": 3,
//      "slug": "divine-shield",
//      "name": "천상의 보호막",
//      "refText": "보호막이 있는 하수인은 피해를 한 번 무시합니다.",
//      "text": "이 하수인은 피해를 한 번 무시합니다."
//    },
