package com.malibin.hearthstone.db.data.reponse

import com.malibin.hearthstone.db.data.entity.BattleGroundCard
import com.malibin.hearthstone.db.data.entity.Card

/**
 * Created By Malibin
 * on 10월 07, 2020
 */

data class RawCard(
    val id: Int,
    val collectible: Int,
    val slug: String,
    val classId: Int,
    val multiClassIds: List<Int>,
    val cardTypeId: Int,
    val cardSetId: Int,
    val rarityId: Int,
    val manaCost: Int,
    val name: String,
    val text: String,
    val image: String,
    val imageGold: String,
    val flavorText: String,
    val cropImage: String?,
    val artistName: String?,
    val minionTypeId: Int?,
    val attack: Int?,
    val keywordIds: List<Int>? = listOf(),
    val durability: Int?,
    val armor: Int?,
    val health: Int?,
    val parentId: Int?,
    val childIds: List<Int>?,
    val battlegrounds: RawBattleGround?,
) {
    fun toCard() = Card(
        id = id,
        collectible = collectible == 1,
        slug = slug,
        classId = classId,
        multiClassIds = multiClassIds,
        cardTypeId = cardTypeId,
        cardSetId = cardSetId,
        rarityId = rarityId,
        artistName = artistName,
        manaCost = manaCost,
        name = name,
        text = text,
        imageUrl = image,
        imageGoldUrl = imageGold,
        flavorText = flavorText,
        cropImageUrl = cropImage ?: "",
        minionTypeId = minionTypeId,
        attack = attack,
        keywordIds = keywordIds ?: emptyList(),
        durability = durability,
        armor = armor,
        health = health,
        parentId = parentId,
        childIds = childIds ?: emptyList(),
        collectedCount = 0,
        isFavorite = false,
    )

    fun toBattleGroundCard() = BattleGroundCard(
        id = id,
        collectible = collectible == 1,
        slug = slug,
        classId = classId,
        multiClassIds = multiClassIds,
        cardTypeId = cardTypeId,
        cardSetId = cardSetId,
        rarityId = rarityId,
        artistName = artistName,
        manaCost = manaCost,
        name = name,
        text = text,
        imageUrl = battlegrounds?.image ?: CANNOT_CONVERT_BATTLEGROUND(this),
        imageGoldUrl = battlegrounds.imageGold,
        flavorText = flavorText,
        cropImageUrl = cropImage ?: "",
        tier = battlegrounds.tier,
        isHero = battlegrounds.hero,
        health = health ?: CANNOT_CONVERT_BATTLEGROUND(this),
        attack = attack ?: CANNOT_CONVERT_BATTLEGROUND(this),
        minionTypeId = minionTypeId ?: CANNOT_CONVERT_BATTLEGROUND(this),
        upgradeId = battlegrounds.upgradeId,
    )

    companion object {
        private val CANNOT_CONVERT_BATTLEGROUND: (rawCard: RawCard) -> Nothing = {
            throw IllegalStateException("해당 카드는 전장 카드가 아닙니다. : $it")
        }
    }
}
