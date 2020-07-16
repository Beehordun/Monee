package com.biodun.domain.repositories

import com.biodun.core.result.ResultOrError
import com.biodun.core.result.Failure
import com.biodun.domain.models.CardInfoEntity

interface CardInfoRepository {
    suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoEntity>
}
