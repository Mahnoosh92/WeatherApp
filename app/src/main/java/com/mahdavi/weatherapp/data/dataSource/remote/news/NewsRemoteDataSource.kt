package com.mahdavi.weatherapp.data.dataSource.remote.news

import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface NewsRemoteDataSource {
    fun getNews(page_size: Int): Single<Response<RemoteNews>>
}