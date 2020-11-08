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

//{
//    "id": 1463,
//    "name": "수습 악마사냥꾼",
//    "slug": "demonhunter-initiate",
//    "releaseDate": "2020-04-08",
//    "type": "base",
//    "collectibleCount": 20,
//    "collectibleRevealedCount": 20,
//    "nonCollectibleCount": 3,
//    "nonCollectibleRevealedCount": 3
//},
//{
//    "id": 1414,
//    "name": "황폐한 아웃랜드",
//    "slug": "ashes-of-outland",
//    "releaseDate": "2020-04-07",
//    "type": "expansion",
//    "collectibleCount": 135,
//    "collectibleRevealedCount": 135,
//    "nonCollectibleCount": 62,
//    "nonCollectibleRevealedCount": 56
//},
//{
//    "id": 1403,
//    "name": "갈라크론드의 부활",
//    "slug": "galakronds-awakening",
//    "releaseDate": "2020-01-15",
//    "type": "adventure",
//    "collectibleCount": 35,
//    "collectibleRevealedCount": 35,
//    "nonCollectibleCount": 10,
//    "nonCollectibleRevealedCount": 5
//},
//
//{
//    "id": 4,
//    "name": "명예의 전당",
//    "slug": "hall-of-fame",
//    "releaseDate": null,
//    "type": "",
//    "collectibleCount": 35,
//    "collectibleRevealedCount": 35,
//    "nonCollectibleCount": 9,
//    "nonCollectibleRevealedCount": 9
//},
//{
//    "id": 3,
//    "name": "오리지널",
//    "slug": "classic",
//    "releaseDate": null,
//    "type": "",
//    "collectibleCount": 240,
//    "collectibleRevealedCount": 240,
//    "nonCollectibleCount": 63,
//    "nonCollectibleRevealedCount": 63
//},
//{
//    "id": 2,
//    "name": "기본",
//    "slug": "basic",
//    "releaseDate": null,
//    "type": "",
//    "collectibleCount": 153,
//    "collectibleRevealedCount": 153,
//    "nonCollectibleCount": 59,
//    "nonCollectibleRevealedCount": 57
//}
