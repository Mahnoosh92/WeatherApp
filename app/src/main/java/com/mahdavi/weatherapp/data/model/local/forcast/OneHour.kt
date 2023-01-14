package com.mahdavi.weatherapp.data.model.local.forcast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class OneHour : ArrayList<OneHourItem>()

@JsonClass(generateAdapter = true)
data class OneHourItem(
    @Json(name = "DateTime") val dateTime: String,
    @Json(name = "EpochDateTime") val epochDateTime: Int,
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean,
    @Json(name = "IconPhrase") val iconPhrase: String,
    @Json(name = "IsDaylight") val isDaylight: Boolean,
    @Json(name = "Link") val link: String,
    @Json(name = "MobileLink") val mobileLink: String,
    @Json(name = "PrecipitationProbability") val precipitationProbability: Int,
    val temperature: Temperature,
    @Json(name = "WeatherIcon") val weatherIcon: Int
)

@JsonClass(generateAdapter = true)
data class Temperature(
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int,
    @Json(name = "Value") val value: Int
)