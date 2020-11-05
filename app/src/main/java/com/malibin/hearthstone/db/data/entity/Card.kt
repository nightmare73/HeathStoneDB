package com.malibin.hearthstone.db.data.entity

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
    override val manaCost: Int,
    override val name: String,
    override val text: String,
    override val imageUrl: String,
    override val imageGoldUrl: String,
    override val flavorText: String,
    override val cropImageUrl: String,
    val artistName: String?,
    val minionTypeId: Int?,
    val attack: Int?,
    val keywordIds: List<Int>,
    val durability: Int?,
    val armor: Int?,
    val health: Int?,
    val parentId: Int?,
    val childIds: List<Int>,
    val collectedCount: Int,
    val isFavorite: Boolean,
) : CommonCardKeywords
