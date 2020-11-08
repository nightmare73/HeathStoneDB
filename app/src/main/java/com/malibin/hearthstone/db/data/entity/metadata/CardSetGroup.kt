package com.malibin.hearthstone.db.data.entity.metadata

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

@Entity
data class CardSetGroup(
    @PrimaryKey
    val slug: String,
    val cardSets: List<String>,
    val name: String,
    val year: Int?,
    val standard: Boolean?,
)

//{
//    "slug": "kraken",
//    "year": 2016,
//    "cardSets": [
//    "mean-streets-of-gadgetzan",
//    "one-night-in-karazhan",
//    "whispers-of-the-old-gods"
//    ],
//    "name": "크라켄의 해",
//    "standard": false,
//    "icon": "icon_cardset_yearofthekraken"
//},
//{
//    "slug": "classic",
//    "year": 2015,
//    "cardSets": [
//    "league-of-explorers",
//    "the-grand-tournament",
//    "blackrock-mountain",
//    "goblins-vs-gnomes",
//    "naxxramas"
//    ],
//    "name": "오리지널 세트",
//    "standard": false,
//    "yearRange": "2014-2015",
//    "icon": "icon_cardset_classic"
//},
//{
//    "slug": "standard",
//    "cardSets": [
//    "madness-at-the-darkmoon-faire",
//    "scholomance-academy",
//    "demonhunter-initiate",
//    "ashes-of-outland",
//    "galakronds-awakening",
//    "descent-of-dragons",
//    "saviors-of-uldum",
//    "rise-of-shadows",
//    "classic",
//    "basic"
//    ],
//    "name": "정규 세트"
//},
//{
//    "slug": "wild",
//    "cardSets": [
//    "madness-at-the-darkmoon-faire",
//    "scholomance-academy",
//    "demonhunter-initiate",
//    "ashes-of-outland",
//    "galakronds-awakening",
//    "descent-of-dragons",
//    "saviors-of-uldum",
//    "rise-of-shadows",
//    "rastakhans-rumble",
//    "the-boomsday-project",
//    "the-witchwood",
//    "kobolds-and-catacombs",
//    "knights-of-the-frozen-throne",
//    "journey-to-ungoro",
//    "mean-streets-of-gadgetzan",
//    "one-night-in-karazhan",
//    "whispers-of-the-old-gods",
//    "league-of-explorers",
//    "the-grand-tournament",
//    "blackrock-mountain",
//    "goblins-vs-gnomes",
//    "naxxramas",
//    "hall-of-fame",
//    "classic",
//    "basic"
//    ],
//    "name": "모든 카드"
//}
