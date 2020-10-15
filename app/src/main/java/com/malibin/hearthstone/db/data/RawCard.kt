package com.malibin.hearthstone.db.data

/**
 * Created By Malibin
 * on 10월 07, 2020
 */

data class RawCard(
    val id: Int,
    val collectible: Int, // 0아니면 1
    val slug: String,
    val classId: Int,
    val multiClassIds: List<Int>,
    val cardTypeId: Int,
    val cardSetId: Int,
    val rarityId: Int,
    val artistName: String,
    val manaCost: Int,
    val name: String,
    val text: String,
    val image: String,
    val imageGold: String,
    val flavorText: String,
    val cropImage: String,
    val minionTypeId: Int? = null,
    val attack: Int? = null,
    val keywordIds: List<Int> = listOf(),
    val durability: Int? = null,
    val armor: Int? = null,
    val health: Int? = null,
    val parentId: Int? = null,
    val childIds: List<Int> = listOf(),
    val battlegrounds: RawBattleGround? = null,
)