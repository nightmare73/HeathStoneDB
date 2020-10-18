package com.malibin.hearthstone.db.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.malibin.hearthstone.db.data.entity.BattleGroundCard
import com.malibin.hearthstone.db.data.entity.Card
import com.malibin.hearthstone.db.data.entity.metadata.*

/**
 * Created By Malibin
 * on 10월 18, 2020
 */

@TypeConverters(TypeConverter::class)
@Database(
    entities = [
        Card::class,
        BattleGroundCard::class,
        ArenaCard::class,
        CardSet::class,
        CardSetGroup::class,
        CardClass::class,
        CardKeyword::class,
        CardRarity::class,
        CardType::class,
        MinionType::class,
        CardBackCategory::class,
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

}
