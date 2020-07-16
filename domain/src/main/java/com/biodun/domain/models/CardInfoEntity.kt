package com.biodun.domain.models

data class CardInfoEntity(val cardType: String,
                         val cardBrand: String,
                         val country: CountryEntity,
                         val bank: BankEntity)
