package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.utils.extensions.getApiError
import io.reactivex.Single
import javax.inject.Inject

class DefaultCityRepository @Inject constructor(private val dataSource: CityDataSource) :
    CityRepository {
    override fun getTopCities(size: Int): Single<ResultWrapper<Exception, List<City>?>> {
        return dataSource.getTopCities(size)
            .map { response ->
                if (response.isSuccessful) {
                    ResultWrapper.build { response.body() }
                } else {
                    ResultWrapper.build { throw Exception(response.getApiError()?.message) }
                }
            }
    }

}