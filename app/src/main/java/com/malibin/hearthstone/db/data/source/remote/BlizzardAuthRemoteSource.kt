package com.malibin.hearthstone.db.data.source.remote

import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.source.BlizzardAuthDataSource
import javax.inject.Inject

/**
 * Created By Malibin
 * on 2월 10, 2021
 */

class BlizzardAuthRemoteSource @Inject constructor(
    private val blizzardOAuthService: BlizzardOAuthService,
) : BlizzardAuthDataSource {

    override suspend fun getAccessToken(): String? {
        return blizzardOAuthService.requestOAuthToken().accessToken
    }

    override suspend fun saveAccessToken(token: String) {
        throw UnsupportedOperationException("cannot call saveAccessToken in remote source")
    }

    override suspend fun isTokenExpired(currentTime: Long): Boolean {
        throw UnsupportedOperationException("cannot call isTokenExpired in remote source")
    }

    override suspend fun saveTokenExpireTime(time: Long) {
        throw UnsupportedOperationException("cannot call saveTokenExpireTime in remote source")
    }
}
