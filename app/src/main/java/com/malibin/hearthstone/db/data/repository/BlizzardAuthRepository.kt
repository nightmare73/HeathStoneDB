package com.malibin.hearthstone.db.data.repository

import com.malibin.hearthstone.db.config.di.annotations.BlizzardAuthLocal
import com.malibin.hearthstone.db.config.di.annotations.BlizzardAuthRemote
import com.malibin.hearthstone.db.data.source.BlizzardAuthDataSource
import com.malibin.hearthstone.db.presentation.utils.printLog
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 29, 2020
 */

class BlizzardAuthRepository @Inject constructor(
    @BlizzardAuthLocal private val blizzardAuthLocalSource: BlizzardAuthDataSource,
    @BlizzardAuthRemote private val blizzardAuthRemoteSource: BlizzardAuthDataSource,
) : BlizzardAuthDataSource {

    override suspend fun getAccessToken(): String {
        val localToken = blizzardAuthLocalSource.getAccessToken()
        if (localToken == null || isTokenExpired(System.currentTimeMillis())) {
            val remoteAccessToken = blizzardAuthRemoteSource.getAccessToken()
                .also { printLog("remoteToken loaded") }
                ?: error("remote access token cannot be null")
            saveAccessToken(remoteAccessToken)
            return remoteAccessToken
        }
        return localToken.also { printLog("localToken loaded") }
    }

    override suspend fun saveAccessToken(token: String) {
        blizzardAuthLocalSource.saveAccessToken(token)
    }

    override suspend fun isTokenExpired(currentTime: Long): Boolean {
        return blizzardAuthLocalSource.isTokenExpired(currentTime)
    }

    override suspend fun saveTokenExpireTime(time: Long) {
        blizzardAuthLocalSource.saveTokenExpireTime(time)
    }
}
