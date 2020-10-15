package com.malibin.hearthstone.db.data

/**
 * Created By Malibin
 * on 10월 07, 2020
 */

interface CommonCardKeywords {
    val id: Int
    val collectible: Boolean
    val slug: String
    val classId: Int
    val multiClassIds: List<Int>
    val cardTypeId: Int
    val cardSetId: Int
    val rarityId: Int
    val artistName: String
    val manaCost: Int
    val name: String
    val text: String
    val imageUrl: String
    val imageGoldUrl: String
    val flavorText: String
    val cropImageUrl: String
}