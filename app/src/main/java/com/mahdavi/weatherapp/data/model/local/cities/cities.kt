package com.mahdavi.weatherapp.data.model.local.cities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    val administrativeArea: AdministrativeArea,
    val country: Country,
    @Json(name = "DataSets") val dataSets: List<String>,
    val details: Details,
    @Json(name = "EnglishName") val englishName: String,
    val geoPosition: GeoPosition,
    @Json(name = "IsAlias") val isAlias: Boolean,
    @Json(name = "Key") val key: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "PrimaryPostalCode") val primaryPostalCode: String,
    @Json(name = "Rank") val rank: Int,
    val region: Region,
    val timeZone: TimeZone,
    @Json(name = "Type") val type: String,
    @Json(name = "Version") val version: Int
)

@JsonClass(generateAdapter = true)
data class AdministrativeArea(
    @Json(name = "CountryID") val countryID: String,
    @Json(name = "EnglishName") val englishName: String,
    @Json(name = "EnglishType") val englishType: String,
    @Json(name = "ID") val id: String,
    @Json(name = "Level") val level: Int,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "LocalizedType") val localizedType: String
)

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "EnglishName") val englishName: String,
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String
)

@JsonClass(generateAdapter = true)
data class Details(
    @Json(name = "BandMap") val bandMap: String,
    @Json(name = "CanonicalLocationKey") val canonicalLocationKey: String,
    @Json(name = "CanonicalPostalCode") val canonicalPostalCode: String,
    @Json(name = "Climo") val climo: String,
    @Json(name = "Key") val Key: String,
    @Json(name = "Population") val population: Int,
    @Json(name = "PrimaryWarningCountyCode") val primaryWarningCountyCode: String,
    @Json(name = "PrimaryWarningZoneCode") val primaryWarningZoneCode: String,
    @Json(name = "Satellite") val satellite: String,
)

@JsonClass(generateAdapter = true)
data class GeoPosition(
    @Json(name = "Latitude") val latitude: Double,
    @Json(name = "Longitude") val longitude: Double
)

@JsonClass(generateAdapter = true)
data class Region(
    @Json(name = "EnglishName") val englishName: String,
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String
)

@JsonClass(generateAdapter = true)
data class TimeZone(
    @Json(name = "Code") val code: String,
    @Json(name = "GmtOffset") val gmtOffset: Double,
    @Json(name = "IsDaylightSaving") val isDaylightSaving: Boolean,
    @Json(name = "Name") val name: String,
    @Json(name = "NextOffsetChange") val nextOffsetChange: String
)

