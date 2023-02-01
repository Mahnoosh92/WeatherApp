package com.mahdavi.weatherapp.data.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.Details
import com.mahdavi.weatherapp.data.model.local.news.Article


@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val score: Double?,
    @ColumnInfo val author: String?,
    @ColumnInfo val authors: String?,
    @ColumnInfo val clean_url: String?,
    @ColumnInfo val country: String?,
    @ColumnInfo val excerpt: String?,
    @ColumnInfo val is_opinion: Boolean?,
    @ColumnInfo val language: String?,
    @ColumnInfo val link: String?,
    @ColumnInfo val media: String?,
    @ColumnInfo val published_date: String?,
    @ColumnInfo val published_date_precision: String?,
    @ColumnInfo val rank: Int?,
    @ColumnInfo val rights: String?,
    @ColumnInfo val summary: String?,
    @ColumnInfo val title: String?,
    @ColumnInfo val topic: String?,
    @ColumnInfo val twitter_account: String?
) {
    fun toArticle() = Article(
        id = id.toString(),
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
