package com.mahdavi.weatherapp.data.repository.news

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.data.model.remote.news.HeadLineNews
import com.mahdavi.weatherapp.data.model.remote.news.HeadlineArticle
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import java.lang.Exception

interface NewsRepository {

    fun getNews(page: Int, update: Boolean): Flowable<ResultWrapper<Exception, List<Article>?>>
    fun getLatestHeadlines(
        topic: String,
        page: Int
    ): Flowable<ResultWrapper<Exception, List<HeadlineArticle?>?>>
}