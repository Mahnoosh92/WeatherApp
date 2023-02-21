package com.mahdavi.weatherapp.data.model.remote.news

import com.squareup.moshi.Json

data class HeadLineNews(
    @Json(name = "articles") val articles: List<RemoteHeadlineArticle?>?,
//    @Json(name = "page") val page: Int?,
//    @Json(name = "page_size") val pageSize: Int?,
//    @Json(name = "status") val status: String?,
//    @Json(name = "total_hits") val totalHits: Int?,
//    @Json(name = "total_pages") val totalPages: Int?,
//    @Json(name = "user_input") val userInput: UserInput?
)
