package com.mahdavi.weatherapp.data.api

import com.mahdavi.weatherapp.BuildConfig
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCity
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCityAutoComplete
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("topcities/{size}")
    fun getTopCities(
        @Path("size") size: Int,
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("details") details: Boolean = true
    ): Flowable<Response<List<RemoteCity>>>

    @GET("cities/autocomplete")
    fun getAutoCompletedCities(
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("q") city: String
    ): Flowable<Response<List<RemoteCityAutoComplete>>>
}