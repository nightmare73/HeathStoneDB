package com.malibin.hearthstone.db.di

import android.content.Context
import androidx.room.Room
import com.malibin.hearthstone.db.data.dao.CardsDao
import com.malibin.hearthstone.db.data.dao.MetaDataDao
import com.malibin.hearthstone.db.data.db.HearthStoneDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created By Malibin
 * on 10월 23, 2020
 */

@Module
@InstallIn(ApplicationComponent::class)
object RoomPersistenceModule {

    @Singleton
    @Provides
    fun provideCardsDao(hearthStoneDataBase: HearthStoneDataBase): CardsDao {
        return hearthStoneDataBase.cardsDao()
    }

    @Singleton
    @Provides
    fun provideMetaDataDao(hearthStoneDataBase: HearthStoneDataBase): MetaDataDao {
        return hearthStoneDataBase.metaDataDao()
    }

    @Singleton
    @Provides
    fun provideHearthStoneDataBase(@ApplicationContext context: Context): HearthStoneDataBase {
        return Room.databaseBuilder(
            context,
            HearthStoneDataBase::class.java,
            "hearthStoneDataBase"
        ).build()
    }
}
