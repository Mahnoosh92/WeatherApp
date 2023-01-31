package com.mahdavi.weatherapp.data.model.remote.news

import com.mahdavi.weatherapp.data.model.local.news.News
import com.squareup.moshi.Json

data class RemoteNews(
    @Json(name = "articles") val articles: List<RemoteArticle>?
) {
    fun toNews() = News(articles?.map {
        it.toArticle()
    })
}
