package com.biodun.domain

import com.biodun.domain.models.BankEntity
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.models.CountryEntity
import java.util.UUID

object TestFakeFactory {

    private val cardType: String = UUID.randomUUID().toString()
    private val cardBrand: String = UUID.randomUUID().toString()
    private val bankName: String = UUID.randomUUID().toString()
    private val country: String = UUID.randomUUID().toString()

    private val bankEntity = BankEntity(bankName = bankName)
    private val countryEntity =
        CountryEntity(countryName = country, countryEmoji = "", currency = "")

    fun getTestCardInfoEntity(): CardInfoEntity {
        return CardInfoEntity(
            cardType = cardType,
            cardBrand = cardBrand,
            country = countryEntity,
            bank = bankEntity
        )
    }
}
