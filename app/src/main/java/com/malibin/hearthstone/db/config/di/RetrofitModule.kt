package com.malibin.hearthstone.db.config.di

import com.malibin.hearthstone.db.config.interceptor.AddingBlizzardTokenInterceptor
import com.malibin.hearthstone.db.config.interceptor.SavingTokenInterceptor
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.service.BlizzardService
import com.malibin.hearthstone.db.presentation.utils.printLog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideBlizzardOAuthService(
        gsonConverterFactory: GsonConverterFactory,
        interceptor: SavingTokenInterceptor,
    ): BlizzardOAuthService {
        val interceptors = listOf(interceptor)
        return Retrofit.Builder()
            .baseUrl(BlizzardOAuthService.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(createOkHttpClient(listOf(), interceptors))
            .build()
            .create(BlizzardOAuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideBlizzardService(
        gsonConverterFactory: GsonConverterFactory,
        interceptor: AddingBlizzardTokenInterceptor,
    ): BlizzardService {
        val networkInterceptors = listOf(interceptor)
        return Retrofit.Builder()
            .baseUrl(BlizzardService.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(createOkHttpClient(networkInterceptors))
            .build()
            .create(BlizzardService::class.java)
    }


    private fun createOkHttpClient(
        networkInterceptors: List<Interceptor> = listOf(),
        applicationInterceptors: List<Interceptor> = listOf(),
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        networkInterceptors.forEach { okHttpClient.addNetworkInterceptor(it) }
        applicationInterceptors.forEach { okHttpClient.addInterceptor(it) }
        okHttpClient.addInterceptor(createHttpLoggingInterceptor())
        return okHttpClient.build()
    }

    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { printLog(it) }
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}
