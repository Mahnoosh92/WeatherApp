package com.mahdavi.weatherapp.data.dataSource.local.city

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response

interface CityLocalDataSource {

    fun getCities(): Flowable<List<CityEntity>>
    fun updateCities(cities: List<CityEntity>): Completable
}