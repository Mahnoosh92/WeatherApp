package com.mahdavi.weatherapp.data.dataSource.local.news

import com.mahdavi.weatherapp.data.db.dao.ArticleDao
import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultNewsLocalDataSource @Inject constructor(private val articleDao: ArticleDao) :
    NewsLocalDataSource {
    override fun getArticles(): Flowable<List<ArticleEntity>> = articleDao.getArticles()

    override fun updateArticles(articles: List<ArticleEntity>): Completable =
        articleDao.updateArticles(articles)

    override fun clearArticles(): Completable = articleDao.clearArticles()
}