package com.biodun.data.remote

import com.biodun.core.result.ResultOrError
import com.biodun.core.result.Failure
import com.biodun.data.model.CardInfoModel

interface RemoteDataSource {
    suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoModel>
}
