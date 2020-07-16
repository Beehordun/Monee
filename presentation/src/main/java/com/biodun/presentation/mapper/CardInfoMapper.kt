package com.biodun.presentation.mapper

import com.biodun.domain.models.CardInfoEntity
import com.biodun.presentation.model.Bank
import com.biodun.presentation.model.CardInfo
import com.biodun.presentation.model.Country
import javax.inject.Inject

class CardInfoMapper @Inject constructor() {

        fun mapToCardInfo(entity: CardInfoEntity): CardInfo {
            return CardInfo(
                cardType = entity.cardType,
                cardBrand = entity.cardBrand,
                bank = Bank(bankName = entity.bank.bankName),
                country = Country(
                    countryName = entity.country.countryName,
                    countryEmoji = entity.country.countryEmoji,
                    currency = entity.country.currency)
            )
        }
}
