package com.mahdavi.weatherapp.data.dataSource.remote.city

import com.mahdavi.weatherapp.data.api.ApiService
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.di.WeatherApiService
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultCityDataSource @Inject constructor(@WeatherApiService private val apiService: ApiService) :
    CityDataSource {
    override fun getTopCities(size: Int) = apiService.getTopCities(size)
    override fun getAutoCompletedCities(city: String) =
        apiService.getAutoCompletedCities(city = city)
}