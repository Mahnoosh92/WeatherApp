package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import io.reactivex.Single

interface CityRepository {
    fun getTopCities(size: Int): Single<ResultWrapper<Exception, List<City>?>>
}