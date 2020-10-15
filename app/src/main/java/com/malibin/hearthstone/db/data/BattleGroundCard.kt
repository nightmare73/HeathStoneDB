package com.malibin.hearthstone.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class BattleGroundCard(
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
    val tier: Int,
    val isHero: Boolean,
    val health: Int,
    val attack: Int,
    val minionTypeId: Int,
    val upgradeId: Int,
) : CommonCardKeywords
