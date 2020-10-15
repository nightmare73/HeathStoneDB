package com.malibin.hearthstone.db.data.reponse

import com.google.gson.annotations.SerializedName

data class OAuthResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expireTime: Long,
)
