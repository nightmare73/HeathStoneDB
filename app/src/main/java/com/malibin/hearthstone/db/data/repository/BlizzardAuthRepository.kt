package com.malibin.hearthstone.db.data.repository

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.malibin.hearthstone.db.data.reponse.OAuthResponse
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.presentation.utils.printLog
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created By Malibin
 * on 10월 29, 2020
 */

class BlizzardAuthRepository @Inject constructor(
    private val blizzardTokenStore: DataStore<Preferences>,
    private val blizzardOAuthService: BlizzardOAuthService,
) {
    // 이건 어떻게 테스트해야하지? 3가지 기능들을. 흠.
    suspend fun getAccessToken(): String {
        val localToken = blizzardTokenStore.data.map { it[KEY_BLIZZARD_ACCESS_TOKEN] }.first()
        return if (localToken == null) {
            getRemoteAccessToken().also { printLog("localToken not exist") }
        } else {
            if (isTokenExpired()) getRemoteAccessToken().also { printLog("localToken expired") }
            else localToken.also { printLog("localToken loaded") }
        }
    }

    private suspend fun isTokenExpired(): Boolean {
        val expireDate = blizzardTokenStore.data.map { it[KEY_EXPIRE_DATE] }.first() ?: 0L
        return expireDate <= System.currentTimeMillis()
    }

    private suspend fun getRemoteAccessToken(): String {
        val response = blizzardOAuthService.requestOAuthToken()
        saveAccessToken(response)
        return response.accessToken
    }

    private suspend fun saveAccessToken(response: OAuthResponse) {
        blizzardTokenStore.edit {
            it[KEY_EXPIRE_DATE] = response.getExpireTime()
            it[KEY_BLIZZARD_ACCESS_TOKEN] = response.accessToken
        }
    }

    companion object {
        private val KEY_EXPIRE_DATE = preferencesKey<Long>("KEY_EXPIRE_DATE")
        private val KEY_BLIZZARD_ACCESS_TOKEN = preferencesKey<String>("BLIZZARD_ACCESS_TOKEN")
    }
}
