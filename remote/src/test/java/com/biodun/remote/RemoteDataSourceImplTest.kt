package com.biodun.remote

import com.biodun.core.result.getOrElse
import com.biodun.data.model.CardInfoModel
import com.biodun.testObjectsFactory.TestFactory
import com.biodun.testObjectsFactory.TestMoneeApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest {

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl
    private lateinit var cardInfoModel: CardInfoModel

    @Before
    fun setUp() {
        val testMoneeApi = TestMoneeApi()
        remoteDataSourceImpl = RemoteDataSourceImpl(testMoneeApi)
        cardInfoModel = TestFactory.getTestCardInfoModel()
    }

    @Test
    fun getCardInfoReturnsCardInfoModel() {
        val cardNumber = "539923"
        runBlocking {
            val returnedCardInfoModel = remoteDataSourceImpl.getCardInfo(cardNumber).getOrElse(null)

            Assert.assertEquals(cardInfoModel.cardType, returnedCardInfoModel?.cardType)
            Assert.assertEquals(cardInfoModel.cardBrand, returnedCardInfoModel?.cardBrand)
        }
    }
}
