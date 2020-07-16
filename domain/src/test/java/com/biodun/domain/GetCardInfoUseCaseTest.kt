package com.biodun.domain

import com.biodun.core.result.ResultOrError
import com.biodun.domain.repositories.CardInfoRepository
import com.biodun.domain.usecases.GetCardInfoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetCardInfoUseCaseTest {

    private lateinit var cardInfoRepository: CardInfoRepository
    private lateinit var getCardInfoUseCase: GetCardInfoUseCase

    @Before
    fun setUp() {
        cardInfoRepository = TestCardInfoRepository()
        getCardInfoUseCase = GetCardInfoUseCase(cardInfoRepository)
    }

    @Test
    fun testCardInfoReturnsResult() = runBlocking {
        val expectedResult = ResultOrError.Result(TestFakeFactory.getTestCardInfoEntity())
        val returnedResult = getCardInfoUseCase.getCardInfo("539926")

        Assert.assertEquals(expectedResult, returnedResult)
    }
}
