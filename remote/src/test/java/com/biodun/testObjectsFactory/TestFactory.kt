package com.biodun.testObjectsFactory

import com.biodun.data.model.BankModel
import com.biodun.data.model.CardInfoModel
import com.biodun.data.model.CountryModel
import java.util.UUID

object TestFactory {

    private val cardType: String = UUID.randomUUID().toString()
    private val cardBrand: String = UUID.randomUUID().toString()
    private val bankName: String = UUID.randomUUID().toString()
    private val country: String = UUID.randomUUID().toString()

    private val bankModel = BankModel(bankName = bankName)
    private val countryModel = CountryModel(countryName = country)

    fun getTestCardInfoModel(): CardInfoModel {
        return CardInfoModel(cardType = cardType,
            cardBrand = cardBrand,
            bank = bankModel,
            country = countryModel)
    }
}
