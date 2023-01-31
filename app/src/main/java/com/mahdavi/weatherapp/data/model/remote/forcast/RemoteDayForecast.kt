package com.mahdavi.weatherapp.data.model.remote.forcast

import com.mahdavi.weatherapp.data.model.local.forecast.*
import com.squareup.moshi.Json

data class RemoteDaysForecast(
    @Json(name = "DailyForecasts") val dailyForecasts: List<RemoteDayForecast>?
)

data class RemoteDayForecast(
    @Json(name = "Date") val date: String?,
    @Json(name = "Day") val day: RemoteDay?,
    @Json(name = "EpochDate") val epochDate: Int?,
    @Json(name = "Link") val link: String?,
    @Json(name = "MobileLink") val mobileLink: String?,
    @Json(name = "Night") val night: RemoteNight?,
    @Json(name = "Sources") val sources: List<String>?,
    @Json(name = "Temperature") val temperature: RemoteTemperature?
) {
    fun toDayForecast() = DayForecast(
        date = date,
        day = day?.toDay(),
        epochDate = epochDate,
        link = link,
        mobileLink = mobileLink,
        night = night?.toNight(),
        sources = sources,
        temperature = temperature?.toTemperature()
    )
}

data class RemoteDay(
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean?,
    @Json(name = "Icon") val icon: Int?,
    @Json(name = "IconPhrase") val iconPhrase: String?,
    @Json(name = "LocalSource") val localSource: RemoteLocalSource?,
    @Json(name = "PrecipitationIntensity") val precipitationIntensity: String?,
    @Json(name = "PrecipitationType") val precipitationType: String?
) {
    fun toDay() = Day(
        hasPrecipitation = hasPrecipitation,
        icon = icon,
        iconPhrase = iconPhrase,
        localSource = localSource?.toLocalSource(),
        precipitationIntensity = precipitationIntensity,
        precipitationType = precipitationType
    )
}

data class RemoteNight(
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean?,
    @Json(name = "Icon") val icon: Int?,
    @Json(name = "IconPhrase") val iconPhrase: String?,
    @Json(name = "LocalSource") val localSource: RemoteLocalSource?
) {
    fun toNight() = Night(
        hasPrecipitation = hasPrecipitation,
        icon = icon,
        iconPhrase = iconPhrase,
        localSource = localSource?.toLocalSource()
    )
}

data class RemoteTemperature(
    @Json(name = "Maximum") val maximum: RemoteMaximum?,
    @Json(name = "Minimum") val minimum: RemoteMinimum?
) {
    fun toTemperature() = Temperature(
        maximum = maximum?.toMaximum(),
        minimum = minimum?.toMinimum()
    )
}

data class RemoteLocalSource(
    @Json(name = "Id") val id: Int?,
    @Json(name = "Name") val name: String?,
    @Json(name = "WeatherCode") val weatherCode: String?
) {
    fun toLocalSource() = LocalSource(
        id = id,
        name = name,
        weatherCode = weatherCode
    )
}

data class RemoteMaximum(
    @Json(name = "Unit") val unit: String?,
    @Json(name = "UnitType") val unitType: Int?,
    @Json(name = "Value") val value: Int?
) {
    fun toMaximum() = Maximum(
        unit = unit,
        unitType = unitType,
        value = value
    )
}

data class RemoteMinimum(
    @Json(name = "Unit") val unit: String?,
    @Json(name = "UnitType") val unitType: Int?,
    @Json(name = "Value") val value: Int?
) {
    fun toMinimum() = Minimum(
        unit = unit,
        unitType = unitType,
        value = value
    )
}