package com.biodun.data.model

import com.google.gson.annotations.SerializedName

data class CardInfoModel(@SerializedName("type") val cardType: String = "",
                         @SerializedName("scheme")val cardBrand: String = "",
                         val country: CountryModel,
                         val bank: BankModel
)
