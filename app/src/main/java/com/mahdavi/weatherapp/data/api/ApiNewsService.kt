package com.mahdavi.weatherapp.data.api

import com.mahdavi.weatherapp.data.model.remote.news.HeadLineNews
import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNewsService {
    @GET("search")
    fun getNews(
        @Query("page_size") page_size: Int = 25,
        @Query("page") page: Int,
        @Query("q") topic: String = "weather",
//        @Query("from") from: String="2021/12/15",
        @Query("countries") countries: String = "CA",
    ): Single<Response<RemoteNews>>

    @GET("latest_headlines")
    fun getLatestHeadlines(
        @Query("page_size") page_size: Int = 25,
        @Query("topic") topic: String,
        @Query("countries") countries: String = "US",
        @Query("page") page: Int
    ): Single<Response<HeadLineNews>>
}