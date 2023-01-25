package com.mahdavi.weatherapp.data.dataSource.remote.city

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCity
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCityAutoComplete
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response

interface CityDataSource {
    fun getTopCities(size: Int): Flowable<Response<List<RemoteCity>>>
    // Autocomplete
    fun getAutoCompletedCities(city:String): Flowable<Response<List<RemoteCityAutoComplete>>>
}