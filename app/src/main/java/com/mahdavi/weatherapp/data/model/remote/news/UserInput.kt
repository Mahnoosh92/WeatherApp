package com.mahdavi.weatherapp.data.model.remote.news

import com.squareup.moshi.Json

data class UserInput(
    @Json(name = "countries") val countries: List<String?>?,
    @Json(name = "from") val from: String?,
    @Json(name = "lang") val lang: String?,
    @Json(name = "not_countries") val notCountries: String?,
    @Json(name = "not_lang") val notLang: String?,
    @Json(name = "not_sources") val notSources: String?,
    @Json(name = "page") val page: Int?,
    @Json(name = "size") val size: Int?,
    @Json(name = "sources") val sources: String?,
    @Json(name = "topic") val topic: String?
)
