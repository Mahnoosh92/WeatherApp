package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response

interface CityRepository {
    fun getTopCities(size: Int, update:Boolean): Flowable<ResultWrapper<Exception, List<City>?>>

    fun getAutoCompletedCities(city:String): Flowable<ResultWrapper<Exception, List<CityAutoComplete>?>>
}