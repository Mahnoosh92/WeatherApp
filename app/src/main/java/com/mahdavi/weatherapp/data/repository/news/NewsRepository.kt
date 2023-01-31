package com.mahdavi.weatherapp.data.repository.news

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import io.reactivex.rxjava3.core.Flowable
import java.lang.Exception

interface NewsRepository {

    fun getNews(page_size: Int): Flowable<ResultWrapper<Exception, List<Article>?>>
}