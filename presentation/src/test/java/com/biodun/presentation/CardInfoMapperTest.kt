package com.biodun.presentation

import com.biodun.presentation.mapper.CardInfoMapper
import org.junit.Assert.assertEquals
import org.junit.Test

class CardInfoMapperTest {

    @Test
    fun mapToCardInfoTest_returns_correct_cardInfo() {
        val cardInfoEntity = TestFakeFactory.getTestCardInfoEntity()
        val cardInfoMapper = CardInfoMapper()
        val expectedCardInfo = TestFakeFactory.getTestCardInfo()

        val returnedCardInfo = cardInfoMapper.mapToCardInfo(cardInfoEntity)

        assertEquals(expectedCardInfo.cardType, returnedCardInfo.cardType)
        assertEquals(expectedCardInfo.cardBrand, returnedCardInfo.cardBrand)
        assertEquals(expectedCardInfo.bank.bankName, returnedCardInfo.bank.bankName)
        assertEquals(expectedCardInfo.country.countryName, returnedCardInfo.country.countryName)
    }
}
