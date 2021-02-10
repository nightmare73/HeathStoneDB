package com.malibin.hearthstone.db.config.di

import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.service.BlizzardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created By Malibin
 * on 10월 23, 2020
 */

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideBlizzardOAuthService(gsonConverterFactory: GsonConverterFactory): BlizzardOAuthService {
        return Retrofit.Builder()
            .baseUrl(BlizzardOAuthService.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(BlizzardOAuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideBlizzardService(gsonConverterFactory: GsonConverterFactory): BlizzardService {
        return Retrofit.Builder()
            .baseUrl(BlizzardService.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(BlizzardService::class.java)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}
