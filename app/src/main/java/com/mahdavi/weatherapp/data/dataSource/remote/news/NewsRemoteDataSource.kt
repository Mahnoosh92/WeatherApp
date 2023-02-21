package com.mahdavi.weatherapp.data.dataSource.remote.news

import com.mahdavi.weatherapp.data.model.remote.news.HeadLineNews
import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Query

interface NewsRemoteDataSource {
    fun getNews(page: Int): Single<Response<RemoteNews>>
    fun getLatestHeadlines(topic: String, page: Int): Single<Response<HeadLineNews>>
}