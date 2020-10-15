package com.malibin.hearthstone.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 07, 2020
 */

@Entity
data class Card(
    @PrimaryKey
    override val id: Int,
    override val collectible: Boolean,
    override val slug: String,
    override val classId: Int,
    override val multiClassIds: List<Int>,
    override val cardTypeId: Int,
    override val cardSetId: Int,
    override val rarityId: Int,
    override val artistName: String,
    override val manaCost: Int,
    override val name: String,
    override val text: String,
    override val imageUrl: String,
    override val imageGoldUrl: String,
    override val flavorText: String,
    override val cropImageUrl: String,
    val minionTypeId: Int? = null,
    val attack: Int? = null,
    val keywordIds: List<Int> = listOf(),
    val durability: Int? = null,
    val armor: Int? = null,
    val health: Int? = null,
    val parentId: Int? = null,
    val childIds: List<Int> = listOf(),
) : CommonCardKeywords