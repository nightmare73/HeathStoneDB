package com.malibin.hearthstone.db.data.service

import android.util.Base64
import com.malibin.hearthstone.db.BuildConfig
import com.malibin.hearthstone.db.data.reponse.OAuthResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
        @Part("grant_type") grantType: RequestBody = getGrantType(),
    ): OAuthResponse

    private fun getEncodedCredential(): String {
        val authCredentials = "${BuildConfig.BLIZZARD_API_ID}:${BuildConfig.BLIZZARD_API_SECRET}"
        val encodedCredentials =
            Base64.encodeToString(authCredentials.toByteArray(), Base64.NO_WRAP)
        return "Basic $encodedCredentials"
    }

    private fun getGrantType(): RequestBody {
        val textMediaType = "text/plain".toMediaType()
        return "client_credentials".toRequestBody(textMediaType)
    }

    companion object {
        const val BASE_URL = "https://kr.battle.net/"
    }
}
