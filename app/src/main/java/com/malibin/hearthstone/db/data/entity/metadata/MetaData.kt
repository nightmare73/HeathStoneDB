package com.malibin.hearthstone.db.data.entity.metadata

/**
 * Created By Malibin
 * on 11월 06, 2020
 */
interface MetaData {
    val id: Int
    val slug: String
    val name: String

    enum class FilterType(val value: String) {
        CARD_TYPE("카드 종류"),
        CARD_SET("확장팩"),
        RARITY("카드 등급"),
        CLASS("직업"),
        MINION_TYPE("종족"),
        KEYWORD("키워드 효과"),
        COST("카드 비용");
    }
}
