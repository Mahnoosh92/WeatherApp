package com.mahdavi.weatherapp.data.model.local.cities

import android.os.Parcelable
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val country: String?,
    val englishName: String?,
    val latitude: Double?,
    val longitude: Double?,
    val key: String?,
    val localizedName: String?,
    val primaryPostalCode: String?,
    val rank: Int?,
    val details: Details?,
    val timeZone: String?,
    val type: String?,
    val version: Int?
) : Parcelable {
    fun toEntity() = CityEntity(
        country = country,
        englishName = englishName,
        latitude = latitude,
        longitude = longitude,
        key = key,
        localizedName = localizedName,
        primaryPostalCode = primaryPostalCode,
        rank = rank,
        details = details,
        timeZone = timeZone,
        type = type,
        version = version
    )
}

@Parcelize
data class Details(
    val bandMap: String?,
    val canonicalLocationKey: String?,
    val canonicalPostalCode: String?,
    val climo: String?,
    val population: Int?,
    val primaryWarningCountyCode: String?,
    val primaryWarningZoneCode: String?,
    val satellite: String?
) : Parcelable

@Parcelize
data class Source(
    val dataType: String?,
    val partnerSourceUrl: String?
) : Parcelable
