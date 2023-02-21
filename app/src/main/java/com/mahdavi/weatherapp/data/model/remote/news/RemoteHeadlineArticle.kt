package com.mahdavi.weatherapp.data.model.remote.news

import com.squareup.moshi.Json

data class RemoteHeadlineArticle(
    @Json(name = "_id") val id: String?,
    @Json(name = "_score") val score: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "authors") val authors: String?,
    @Json(name = "clean_url") val cleanUrl: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "excerpt") val excerpt: String?,
    @Json(name = "is_opinion") val isOpinion: Boolean?,
    @Json(name = "language") val language: String?,
    @Json(name = "link") val link: String?,
    @Json(name = "media") val media: String?,
    @Json(name = "published_date") val publishedDate: String?,
    @Json(name = "published_date_precision") val publishedDatePrecision: String?,
    @Json(name = "rank") val rank: Int?,
    @Json(name = "rights") val rights: String?,
    @Json(name = "summary") val summary: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "topic") val topic: String?,
    @Json(name = "twitter_account") val twitterAccount: String?
) {
    fun toHeadlineArticle() = HeadlineArticle(
        id = id,
        score = score,
        author = author,
        authors = authors,
        cleanUrl = cleanUrl,
        country = country,
        excerpt = excerpt,
        isOpinion = isOpinion,
        language = language,
        link = link,
        media = media,
        publishedDate = publishedDate,
        publishedDatePrecision = publishedDatePrecision,
        rank = rank,
        rights = rights,
        summary = summary,
        title = title,
        topic = topic,
        twitterAccount = twitterAccount
    )

}

