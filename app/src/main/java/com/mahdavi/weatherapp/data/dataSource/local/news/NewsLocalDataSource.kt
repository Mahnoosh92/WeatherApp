package com.mahdavi.weatherapp.data.dataSource.local.news

import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface NewsLocalDataSource {
    fun getArticles(): Flowable<List<ArticleEntity>>
    fun updateArticles(cities: List<ArticleEntity>): Completable
    fun clearArticles(): Completable
}