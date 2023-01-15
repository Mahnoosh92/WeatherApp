package com.mahdavi.weatherapp.data.dataSource.remote.city


import com.mahdavi.weatherapp.data.model.local.cities.City
import io.reactivex.Single
import retrofit2.Response

interface CityDataSource {
    fun getTopCities(size: Int): Single<Response<List<City>>>
}