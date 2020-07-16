package com.biodun.domain

import com.biodun.core.result.Failure
import com.biodun.core.result.ResultOrError
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.repositories.CardInfoRepository

class TestCardInfoRepository : CardInfoRepository {

    override suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoEntity> =
        ResultOrError.Result(TestFakeFactory.getTestCardInfoEntity())
}
