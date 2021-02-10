package com.malibin.hearthstone.db.data.source

/**
 * Created By Malibin
 * on 2월 10, 2021
 *
 * 토큰 만료 시 토큰 재발급 및 직전 요청 재요청 관련 코드를 작성 한 뒤에는
 * expire 관련 코드 지우면 좋을 듯 싶습니다.
 */

interface BlizzardAuthDataSource {

    suspend fun getAccessToken(): String?

    suspend fun saveAccessToken(token: String)

    suspend fun isTokenExpired(currentTime: Long): Boolean

    suspend fun saveTokenExpireTime(time: Long)
}
