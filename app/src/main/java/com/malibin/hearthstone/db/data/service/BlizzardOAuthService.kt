package com.malibin.hearthstone.db.data.service

import android.util.Base64
import com.malibin.hearthstone.db.BuildConfig
import com.malibin.hearthstone.db.data.reponse.OAuthResponse
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * Created By Malibin
 * on 10월 16, 2020
 */
interface BlizzardOAuthService {
    @Multipart
    @POST("oauth/token")
    suspend fun requestOAuthToken(
        @Header("Authorization") auth: String = getEncodedCredential(),
        @Part("grant_type") grant_type: RequestBody = getGrantType(),
    ): OAuthResponse

    private fun getEncodedCredential(): String {
        val authCredentials = "${BuildConfig.BLIZZARD_API_ID}:${BuildConfig.BLIZZARD_API_SECRET}"
        val encodedCredentials =
            Base64.encodeToString(authCredentials.toByteArray(), Base64.DEFAULT)
        return "Basic $encodedCredentials"
    }

    private fun getGrantType(): RequestBody {
        val textMediaType = MediaType.parse("text/plain")
        return RequestBody.create(textMediaType, "client_credentials")
    }

    companion object {
        const val BASE_URL = "https://kr.battle.net/"
    }
}
