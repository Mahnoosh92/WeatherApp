package com.mahdavi.weatherapp.data.dataSource.remote.news

import com.mahdavi.weatherapp.data.api.ApiNewsService
import com.mahdavi.weatherapp.data.model.remote.news.HeadLineNews
import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import com.mahdavi.weatherapp.di.NewsApiService
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class DefaultNewsRemoteDataSource @Inject constructor(@NewsApiService private val apiNewsService: ApiNewsService) :
    NewsRemoteDataSource {
    override fun getNews(page: Int): Single<Response<RemoteNews>> =
        apiNewsService.getNews(page = page)

    override fun getLatestHeadlines(topic: String, page: Int): Single<Response<HeadLineNews>> = apiNewsService.getLatestHeadlines(topic = topic, page = page)
}