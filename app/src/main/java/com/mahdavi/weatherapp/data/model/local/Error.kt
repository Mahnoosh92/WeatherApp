package com.mahdavi.weatherapp.data.model.local

import com.squareup.moshi.Json

data class MyErrorWeather(
    @Json(name = "Code") val code: String?,
    @Json(name = "Message") val message: String?,
    @Json(name = "Reference") val reference: String?,
)

data class MyErrorNews(
    @Json(name = "status") val status: String?,
    @Json(name = "code") val code: String?,
    @Json(name = "message") val message: String?,
)