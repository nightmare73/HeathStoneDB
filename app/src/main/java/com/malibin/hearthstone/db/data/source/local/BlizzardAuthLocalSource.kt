package com.malibin.hearthstone.db.data.source.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.malibin.hearthstone.db.data.source.BlizzardAuthDataSource
import com.malibin.hearthstone.db.data.utils.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created By Malibin
 * on 2월 10, 2021
 */

class BlizzardAuthLocalSource @Inject constructor(
    private val blizzardTokenStore: DataStore<Preferences>,
) : BlizzardAuthDataSource {

    override suspend fun getAccessToken(): String? {
        return withContext(Dispatchers.IO) {
            blizzardTokenStore[KEY_BLIZZARD_ACCESS_TOKEN].first()
        }
    }

    override suspend fun saveAccessToken(token: String) {
        withContext(Dispatchers.IO) {
            blizzardTokenStore.edit { it[KEY_BLIZZARD_ACCESS_TOKEN] = token }
        }
    }

    override suspend fun isTokenExpired(currentTime: Long): Boolean {
        val expireTime = withContext(Dispatchers.IO) {
            blizzardTokenStore[KEY_EXPIRE_TIME].first() ?: 0L
        }
        return expireTime <= currentTime
    }

    override suspend fun saveTokenExpireTime(time: Long) {
        withContext(Dispatchers.IO) {
            blizzardTokenStore.edit { it[KEY_EXPIRE_TIME] = time }
        }
    }

    companion object {
        private val KEY_EXPIRE_TIME = longPreferencesKey("KEY_EXPIRE_TIME")
        private val KEY_BLIZZARD_ACCESS_TOKEN = stringPreferencesKey("BLIZZARD_ACCESS_TOKEN")
    }
}
