package com.mahdavi.weatherapp.data.model.local

import com.squareup.moshi.Json

data class MyError(
    @Json(name = "Code") val code: String?,
    @Json(name = "Message") val message: String?,
    @Json(name = "Reference") val reference: String?,
)