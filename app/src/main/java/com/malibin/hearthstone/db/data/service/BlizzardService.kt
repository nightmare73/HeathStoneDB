package com.malibin.hearthstone.db.data.service

import com.malibin.hearthstone.db.data.reponse.CardsResponse
import com.malibin.hearthstone.db.data.reponse.RawCard
import com.malibin.hearthstone.db.data.reponse.metadata.MetaDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created By Malibin
 * on 10월 16, 2020
 */

interface BlizzardService {

    @GET("/hearthstone/cards")
    suspend fun getCards(
        @Query("page") page: Int = 1,
        @Query("gameMode") gamaMode: String = "constructed",
        @Query("region") region: String = "kr",
        @Query("locale") locale: String = "ko_KR",
    ): CardsResponse

    @GET("/hearthstone/cards/{idorslug}")
    suspend fun fetchCard(
        @Query("idorslug") idOrSlug: String,
        @Query("gameMode") gamaMode: String = "constructed",
        @Query("region") region: String = "kr",
        @Query("locale") locale: String = "ko_KR",
    ): RawCard

    @GET("/hearthstone/metadata")
    suspend fun getMetaData(
        @Query("region") region: String = "kr",
        @Query("locale") locale: String = "ko_KR",
    ): MetaDataResponse

    companion object {
        const val BASE_URL = "https://kr.api.blizzard.com"
    }
}
