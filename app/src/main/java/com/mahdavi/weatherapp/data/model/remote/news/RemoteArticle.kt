package com.mahdavi.weatherapp.data.model.remote.news

import com.mahdavi.weatherapp.data.model.local.news.Article
import com.squareup.moshi.Json


data class RemoteArticle(
    @Json(name = "_id") val id: String?,
    @Json(name = "_score") val score: Double?,
    @Json(name = "author") val author: String?,
    @Json(name = "authors") val authors: List<String>?,
    @Json(name = "clean_url") val clean_url: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "excerpt") val excerpt: String?,
    @Json(name = "is_opinion") val is_opinion: Boolean?,
    @Json(name = "language") val language: String?,
    @Json(name = "link") val link: String?,
    @Json(name = "media") val media: String?,
    @Json(name = "published_date") val published_date: String?,
    @Json(name = "published_date_precision") val published_date_precision: String?,
    @Json(name = "rank") val rank: Int?,
    @Json(name = "rights") val rights: String?,
    @Json(name = "summary") val summary: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "topic") val topic: String?,
    @Json(name = "twitter_account") val twitter_account: String?
) {
    fun toArticle() = Article(
        id = id,
        score = score,
        author = author,
        authors = authors,
        clean_url = clean_url,
        country = country,
        excerpt = excerpt,
        is_opinion = is_opinion,
        language = language,
        link = link,
        media = media,
        published_date = published_date,
        published_date_precision = published_date_precision,
        rank = rank,
        rights = rights,
        summary = summary,
        title = title,
        topic = topic,
        twitter_account = twitter_account
    )
}