package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import io.reactivex.Single
import io.reactivex.rxjava3.core.Flowable

interface CityRepository {
    fun getTopCities(size: Int): Flowable<ResultWrapper<Exception, List<City>?>>
}