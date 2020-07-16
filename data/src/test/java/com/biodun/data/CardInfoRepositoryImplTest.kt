package com.biodun.data

import com.biodun.core.result.ResultOrError
import com.biodun.data.mapper.CardInfoEntityMapper
import com.biodun.data.remote.RemoteDataSource
import com.biodun.data.repositories.CardInfoRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CardInfoRepositoryImplTest {

    private lateinit var cardInfoEntityMapper: CardInfoEntityMapper
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var cardInfoRepositoryImpl: CardInfoRepositoryImpl

    @Before
    fun setUp() {
        remoteDataSource = TestRemoteDataSource()
        cardInfoEntityMapper = CardInfoEntityMapper()
        cardInfoRepositoryImpl = CardInfoRepositoryImpl(
            remoteDataSource,
            cardInfoEntityMapper
        )
    }

    @Test
    fun testCardInfoReturnsResult() = runBlocking {
        val expectedResult = ResultOrError.Result(TestFakeFactory.getTestCardInfoEntity())
        val returnedResult = cardInfoRepositoryImpl.getCardInfo("539926")

        assertEquals(expectedResult, returnedResult)
    }
}