package com.biodun.presentation

import com.biodun.domain.models.BankEntity
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.models.CountryEntity
import com.biodun.presentation.model.Bank
import com.biodun.presentation.model.CardInfo
import com.biodun.presentation.model.Country
import java.util.UUID

object TestFakeFactory {

    private val cardType: String = UUID.randomUUID().toString()
    private val cardBrand: String = UUID.randomUUID().toString()
    private val bankName: String = UUID.randomUUID().toString()
    private val country: String = UUID.randomUUID().toString()

    private val bank = Bank(bankName = bankName)
    private val countryModel = Country(countryName = country, countryEmoji = "", currency = "")

    private val bankEntity = BankEntity(bankName = bankName)
    private val countryEntity =
        CountryEntity(countryName = country, countryEmoji = "", currency = "")

    fun getTestCardInfo(): CardInfo {
        return CardInfo(
            cardType = cardType,
            cardBrand = cardBrand,
            bank = bank,
            country = countryModel
        )
    }

    fun getTestCardInfoEntity(): CardInfoEntity {
        return CardInfoEntity(
            cardType = cardType,
            cardBrand = cardBrand,
            country = countryEntity,
            bank = bankEntity
        )
    }
}
