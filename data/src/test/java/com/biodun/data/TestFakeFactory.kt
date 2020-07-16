package com.biodun.data

import com.biodun.data.model.BankModel
import com.biodun.data.model.CardInfoModel
import com.biodun.data.model.CountryModel
import com.biodun.data.remote.RemoteDataSource
import com.biodun.domain.models.BankEntity
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.models.CountryEntity
import java.util.UUID

object TestFakeFactory {

    private val cardType: String = UUID.randomUUID().toString()
    private val cardBrand: String = UUID.randomUUID().toString()
    private val bankName: String = UUID.randomUUID().toString()
    private val country: String = UUID.randomUUID().toString()

    private val bank = BankModel(bankName = bankName)
    private val countryModel = CountryModel(countryName = country, countryEmoji = "", currency = "")

    private val bankEntity = BankEntity(bankName = bankName)
    private val countryEntity =
        CountryEntity(countryName = country, countryEmoji = "", currency = "")

    fun getTestCardInfoModel(): CardInfoModel {
        return CardInfoModel(
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
