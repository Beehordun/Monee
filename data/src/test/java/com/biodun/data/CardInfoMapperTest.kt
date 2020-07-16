package com.biodun.data

import com.biodun.data.mapper.CardInfoEntityMapper
import org.junit.Assert.assertEquals
import org.junit.Test

class CardInfoEntityTest {

    @Test
    fun mapToCardInfoEntityTest_returns_correct_cardInfo() {
        val cardInfoModel= TestFakeFactory.getTestCardInfoModel()
        val cardInfoEntityMapper = CardInfoEntityMapper()
        val expectedCardInfoEntity = TestFakeFactory.getTestCardInfoEntity()

        val returnedCardInfo = cardInfoEntityMapper.mapToEntity(cardInfoModel)

        assertEquals(expectedCardInfoEntity.cardType, returnedCardInfo.cardType)
        assertEquals(expectedCardInfoEntity.cardBrand, returnedCardInfo.cardBrand)
        assertEquals(expectedCardInfoEntity.bank.bankName, returnedCardInfo.bank.bankName)
        assertEquals(expectedCardInfoEntity.country.countryName, returnedCardInfo.country.countryName)
    }
}
