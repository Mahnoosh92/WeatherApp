package com.mahdavi.weatherapp.data.model.local.autocomplete

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class Autocomplete : ArrayList<AutocompleteItem>()

@JsonClass(generateAdapter = true)
data class AutocompleteItem(
    @Json(name = "Country") val country: Country,
    @Json(name = "Key") val key: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "Rank") val rank: Int,
    @Json(name = "Type") val type: String,
    @Json(name = "Version") val version: Int
)

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String
)