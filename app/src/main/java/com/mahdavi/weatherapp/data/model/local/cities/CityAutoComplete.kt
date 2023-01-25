package com.mahdavi.weatherapp.data.model.local.cities

import com.squareup.moshi.Json



data class CityAutoComplete(
    val country: CityAutoCompleteCountry,
    val key: String,
    val localizedName: String,
    val rank: Int,
    val type: String,
    val version: Int
)


data class CityAutoCompleteCountry(
    val id: String,
    val localizedName: String
)
