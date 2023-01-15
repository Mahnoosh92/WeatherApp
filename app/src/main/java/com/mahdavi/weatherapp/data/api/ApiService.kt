package com.mahdavi.weatherapp.data.api

import com.mahdavi.weatherapp.data.model.local.cities.City
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("topcities/{size}")
    fun getTopCities(@Path("size") size: Int): Single<Response<List<City>>>
}