package com.mahdavi.weatherapp.data.model.local.forecast


data class DayForecast(
    val date: String?,
    val day: Day?,
    val epochDate: Int?,
    val link: String?,
    val mobileLink: String?,
    val night: Night?,
    val sources: List<String>?,
    val temperature: Temperature?
)

data class Day(
    val hasPrecipitation: Boolean?,
    val icon: Int?,
    val iconPhrase: String?,
    val localSource: LocalSource?,
    val precipitationIntensity: String?,
    val precipitationType: String?
)

data class Night(
    val hasPrecipitation: Boolean?,
    val icon: Int?,
    val iconPhrase: String?,
    val localSource: LocalSource?
)

data class Temperature(
    val maximum: Maximum?,
    val minimum: Minimum?
)

data class LocalSource(
    val id: Int?,
    val name: String?,
    val weatherCode: String?
)

data class Maximum(
    val unit: String?,
    val unitType: Int?,
    val value: Int?
)

data class Minimum(
    val unit: String?,
    val unitType: Int?,
    val value: Int?
)
