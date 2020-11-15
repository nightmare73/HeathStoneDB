package com.malibin.hearthstone.db.data.entity.metadata

/**
 * Created By Malibin
 * on 11월 06, 2020
 */
interface MetaData {
    val id: Int
    val slug: String
    val name: String

    enum class FilterType(val value: String, val queryKey: String) {
        CARD_TYPE("카드 종류", "cardTypeId"),
        CARD_SET("확장팩", "cardSetId"),
        RARITY("카드 등급", "rarityId"),
        CLASS("직업", "classId"),
        MINION_TYPE("종족", "minionTypeId"),
        KEYWORD("키워드 효과", "keywordIds"),
        COST("카드 비용", "manaCost");
    }
}
