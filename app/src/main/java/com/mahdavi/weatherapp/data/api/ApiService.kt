package com.mahdavi.weatherapp.data.api

import com.mahdavi.weatherapp.BuildConfig
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCity
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCityAutoComplete
import com.mahdavi.weatherapp.data.model.remote.forcast.RemoteDaysForecast
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("locations/v1/topcities/{size}")
    fun getTopCities(
        @Path("size") size: Int,
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("details") details: Boolean = true
    ): Flowable<Response<List<RemoteCity>>>

    @GET("locations/v1/cities/autocomplete")
    fun getAutoCompletedCities(
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("q") city: String
    ): Flowable<Response<List<RemoteCityAutoComplete>>>

    @GET("forecasts/v1/daily/1day/{key}")
    fun getOneDayForcast(
        @Path("key") key: String,
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("details") details: Boolean = true
    ): Flowable<Response<RemoteDaysForecast>>

    @GET("forecasts/v1/daily/5day/{key}")
    fun getFiveDayForcast(
        @Path("key") key: String,
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("details") details: Boolean = true
    ): Flowable<Response<RemoteDaysForecast>>
}