package com.malibin.hearthstone.db.config.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.malibin.hearthstone.db.config.di.annotations.BlizzardAuthLocal
import com.malibin.hearthstone.db.config.di.annotations.BlizzardAuthRemote
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.source.BlizzardAuthDataSource
import com.malibin.hearthstone.db.data.source.local.BlizzardAuthLocalSource
import com.malibin.hearthstone.db.data.source.remote.BlizzardAuthRemoteSource
import dagger.Provides
import javax.inject.Singleton

/**
 * Created By Malibin
 * on 2월 11, 2021
 */

object DataSourceModule {

    @BlizzardAuthLocal
    @Singleton
    @Provides
    fun providesBlizzardAuthLocalSource(dataStore: DataStore<Preferences>): BlizzardAuthDataSource {
        return BlizzardAuthLocalSource(dataStore)
    }

    @BlizzardAuthRemote
    @Singleton
    @Provides
    fun providesBlizzardAuthRemoteSource(blizzardOAuthService: BlizzardOAuthService): BlizzardAuthDataSource {
        return BlizzardAuthRemoteSource(blizzardOAuthService)
    }
}
