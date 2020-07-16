package com.biodun.data.model

import com.google.gson.annotations.SerializedName

data class CountryModel(@SerializedName("name")
                        val countryName: String = "",
                        @SerializedName("emoji")
                        val countryEmoji: String = "",
                        val currency: String = "")
