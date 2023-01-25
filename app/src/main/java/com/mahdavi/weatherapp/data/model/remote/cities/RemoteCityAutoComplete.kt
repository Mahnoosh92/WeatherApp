package com.mahdavi.weatherapp.data.model.remote.cities

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoCompleteCountry
import com.squareup.moshi.Json

data class RemoteCityAutoComplete(
    @Json(name = "Country") val country: RemoteCityAutoCompleteCountry,
    @Json(name = "Key") val key: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "Rank") val rank: Int,
    @Json(name = "Type") val type: String,
    @Json(name = "Version") val version: Int
) {
    fun toCityAutoComplete() = CityAutoComplete(
        country = country.toCityAutoCompleteCountry(),
        key = key,
        localizedName = localizedName,
        rank = rank,
        type = type,
        version = version
    )
}


data class RemoteCityAutoCompleteCountry(
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String
) {
    fun toCityAutoCompleteCountry() = CityAutoCompleteCountry(
        id = id,
        localizedName = localizedName
    )
}