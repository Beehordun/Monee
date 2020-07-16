package com.biodun.data.mapper

import com.biodun.data.model.CardInfoModel
import com.biodun.domain.models.BankEntity
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.models.CountryEntity
import javax.inject.Inject

class CardInfoEntityMapper @Inject constructor() {

    fun mapToEntity(model: CardInfoModel): CardInfoEntity {
        return CardInfoEntity(
            cardType = model.cardType ?: "",
            cardBrand = model.cardBrand ?: "",
            bank = BankEntity(bankName = model.bank.bankName ?: ""),
            country = CountryEntity(
                countryName = model.country.countryName ?: "",
                countryEmoji = model.country.countryEmoji ?: "",
                currency = model.country.currency ?: "")
        )
    }
}
