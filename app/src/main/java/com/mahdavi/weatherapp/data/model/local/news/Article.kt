package com.mahdavi.weatherapp.data.model.local.news

import com.squareup.moshi.Json

data class Article(
    val id: String?,
    val score: Double?,
    val author: String?,
    val authors: List<String>?,
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
)
