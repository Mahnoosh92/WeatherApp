package com.mahdavi.weatherapp.data.model.local.news

import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import com.squareup.moshi.Json

data class Article(
    val id: String?,
    val score: Double?,
    val author: String?,
    val authors: String?,
    val clean_url: String?,
    val country: String?,
    val excerpt: String?,
    val is_opinion: Boolean?,
    val language: String?,
    val link: String?,
    val media: String?,
    val published_date: String?,
    val published_date_precision: String?,
    val rank: Int?,
    val rights: String?,
    val summary: String?,
    val title: String?,
    val topic: String?,
    val twitter_account: String?
) {
    fun toArticleEntity() = ArticleEntity(
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
