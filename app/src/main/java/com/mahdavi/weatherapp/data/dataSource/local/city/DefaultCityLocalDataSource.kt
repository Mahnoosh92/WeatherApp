package com.mahdavi.weatherapp.data.dataSource.local.city

import com.mahdavi.weatherapp.data.db.dao.CityDao
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultCityLocalDataSource @Inject constructor(private val cityDao: CityDao) :
    CityLocalDataSource {
    override fun getCities(): Flowable<List<CityEntity>> {
        return cityDao.getCities()
    }

    override fun updateCities(cities: List<CityEntity>): Completable = cityDao.updateCities(cities)
}