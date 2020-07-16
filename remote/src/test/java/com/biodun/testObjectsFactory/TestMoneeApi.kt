package com.biodun.testObjectsFactory

import com.biodun.data.model.CardInfoModel
import com.biodun.remote.MoneeApi

class TestMoneeApi: MoneeApi {

    override suspend fun getCardInfo(cardNumber: String): CardInfoModel {
        return TestFactory.getTestCardInfoModel()
    }
}
