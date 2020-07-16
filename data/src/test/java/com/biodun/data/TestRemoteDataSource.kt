package com.biodun.data

import com.biodun.core.result.Failure
import com.biodun.core.result.ResultOrError
import com.biodun.data.model.CardInfoModel
import com.biodun.data.remote.RemoteDataSource

class TestRemoteDataSource: RemoteDataSource {
    override suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoModel> {
        return ResultOrError.Result(TestFakeFactory.getTestCardInfoModel())
    }

}