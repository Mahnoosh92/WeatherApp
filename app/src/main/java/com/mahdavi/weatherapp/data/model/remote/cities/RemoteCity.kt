package com.mahdavi.weatherapp.data.model.remote.cities

import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.Details
import com.mahdavi.weatherapp.data.model.local.cities.Source
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class RemoteCity(
    @Json(name = "AdministrativeArea") val administrativeArea: AdministrativeArea?,
    @Json(name = "Country") val country: Country?,
    @Json(name = "DataSets") val dataSets: List<String>?,
    @Json(name = "Details") val details: RemoteDetails?,
    @Json(name = "EnglishName") val englishName: String?,
    @Json(name = "GeoPosition") val geoPosition: GeoPosition?,
    @Json(name = "IsAlias") val isAlias: Boolean?,
    @Json(name = "Key") val key: String?,
    @Json(name = "LocalizedName") val localizedName: String?,
    @Json(name = "PrimaryPostalCode") val primaryPostalCode: String?,
    @Json(name = "Rank") val rank: Int?,
    @Json(name = "Region") val region: Region?,
    @Json(name = "TimeZone") val timeZone: TimeZone?,
    @Json(name = "Type") val type: String?,
    @Json(name = "Version") val version: Int?
) {
    fun toCity() = City(
        country = country?.englishName,
        englishName = englishName,
        latitude = geoPosition?.latitude,
        longitude = geoPosition?.longitude,
        key = key,
        localizedName = localizedName,
        primaryPostalCode = primaryPostalCode,
        rank = rank,
        details = details?.toDetails(),
        timeZone = timeZone?.name,
        type = type,
        version = version
    )
}

data class AdministrativeArea(
    @Json(name = "CountryID") val countryID: String?,
    @Json(name = "EnglishName") val englishName: String?,
    @Json(name = "EnglishType") val englishType: String?,
    @Json(name = "ID") val id: String?,
    @Json(name = "Level") val level: Int?,
    @Json(name = "LocalizedName") val localizedName: String?,
    @Json(name = "LocalizedType") val localizedType: String?
)

data class Country(
    @Json(name = "EnglishName") val englishName: String?,
    @Json(name = "ID") val id: String?,
    @Json(name = "LocalizedName") val localizedName: String?
)

data class RemoteDetails(
    @Json(name = "BandMap") val bandMap: String?,
    @Json(name = "CanonicalLocationKey") val canonicalLocationKey: String?,
    @Json(name = "CanonicalPostalCode") val canonicalPostalCode: String?,
    @Json(name = "Climo") val climo: String?,
    @Json(name = "Key") val Key: String?,
    @Json(name = "Population") val population: Int?,
    @Json(name = "PrimaryWarningCountyCode") val primaryWarningCountyCode: String?,
    @Json(name = "PrimaryWarningZoneCode") val primaryWarningZoneCode: String?,
    @Json(name = "Satellite") val satellite: String?
//    @Json(name = "Source") val source: List<RemoteSource>?
) {
    fun toDetails() = Details(
        bandMap = bandMap,
        canonicalLocationKey = canonicalLocationKey,
        canonicalPostalCode = canonicalPostalCode,
        climo = climo,
        population = population,
        primaryWarningCountyCode = primaryWarningCountyCode,
        primaryWarningZoneCode = primaryWarningZoneCode,
        satellite = satellite
    )
}

data class RemoteSource(
    @Json(name = "DataType") val dataType: String?,
    @Json(name = "PartnerSourceUrl") val partnerSourceUrl: String?
){
    fun toSource() = Source(
        dataType = dataType,
        partnerSourceUrl = partnerSourceUrl
    )
}

data class GeoPosition(
    @Json(name = "Latitude") val latitude: Double?,
    @Json(name = "Longitude") val longitude: Double?
)

data class Region(
    @Json(name = "EnglishName") val englishName: String?,
    @Json(name = "ID") val id: String?,
    @Json(name = "LocalizedName") val localizedName: String?
)

data class TimeZone(
    @Json(name = "Code") val code: String?,
    @Json(name = "GmtOffset") val gmtOffset: Double?,
    @Json(name = "IsDaylightSaving") val isDaylightSaving: Boolean?,
    @Json(name = "Name") val name: String?,
    @Json(name = "NextOffsetChange") val nextOffsetChange: String?
)
