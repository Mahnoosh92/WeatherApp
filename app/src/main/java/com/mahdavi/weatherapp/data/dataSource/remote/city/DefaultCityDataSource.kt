package com.mahdavi.weatherapp.data.dataSource.remote.city

import com.mahdavi.weatherapp.data.api.ApiService
import javax.inject.Inject

class DefaultCityDataSource @Inject constructor(private val apiService: ApiService) : CityDataSource{
    override fun getTopCities(size: Int) = apiService.getTopCities(size)
}