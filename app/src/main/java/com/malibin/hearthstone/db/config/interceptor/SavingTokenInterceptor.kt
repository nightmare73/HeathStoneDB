package com.malibin.hearthstone.db.config.interceptor

import com.malibin.hearthstone.db.data.source.local.BlizzardAuthLocalSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject
import javax.inject.Inject

/**
 * Created By Malibin
 * on 2월 13, 2021
 */

class SavingTokenInterceptor @Inject constructor(
    private val blizzardAuthLocalSource: BlizzardAuthLocalSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        val responseJson = JSONObject(originalResponse.body?.string() ?: "{}")
        val expireTime = responseJson.getLong("expires_in") * 1_000 + System.currentTimeMillis()
        CoroutineScope(Dispatchers.IO).launch {
            blizzardAuthLocalSource.saveTokenExpireTime(expireTime)
        }
        return originalResponse.newBuilder()
            .body(responseJson.toString().toResponseBody(originalResponse.body?.contentType()))
            .build()
    }
}
