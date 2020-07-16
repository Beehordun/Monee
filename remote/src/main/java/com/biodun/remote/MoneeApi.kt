package com.biodun.remote

import com.biodun.data.model.CardInfoModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MoneeApi {
        @GET("/{cardNumber}")
        suspend fun getCardInfo(@Path("cardNumber") cardNumber: String): CardInfoModel
}
