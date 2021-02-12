package com.malibin.hearthstone.db.config.interceptor

import com.malibin.hearthstone.db.data.repository.BlizzardAuthRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created By Malibin
 * on 2월 12, 2021
 */

class AddingBlizzardTokenInterceptor @Inject constructor(
    private val blizzardAuthRepository: BlizzardAuthRepository,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = runBlocking { blizzardAuthRepository.getAccessToken() }

        val tokenAddedUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("access_token", accessToken)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(tokenAddedUrl)
            .build()

        return chain.proceed(newRequest)
    }
}
