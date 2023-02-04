package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.dataSource.local.city.CityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.utils.extensions.getApiErrorWeather
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultCityRepository @Inject constructor(
    private val remoteDataSource: CityDataSource,
    private val localDataSource: CityLocalDataSource
) : CityRepository {

    override fun getTopCities(
        size: Int, update: Boolean
    ): Flowable<ResultWrapper<Exception, List<City>?>> {
        return if (update) {
            remoteDataSource.getTopCities(size)
                .map { response ->
                    if (!response.isSuccessful) {
                        ResultWrapper.build {
                            throw Exception(
                                response.getApiErrorWeather()?.message ?: "Something went wrong"
                            )
                        }
                    }
                    response.body() ?: throw Exception("Response is null")
                }
                .flatMap { cities ->
                    localDataSource.updateCities(
                        cities.map {
                            it.toCity().toEntity()
                        }
                    ).andThen(localDataSource.getCities()
                        .map {
                            ResultWrapper.build {
                                it.map { cityEntity ->
                                    cityEntity.toCity()
                                }
                            }
                        }
                    )
                }
        } else {
            localDataSource.getCities()
                .map {
                    ResultWrapper.build {
                        it.map { cityEntity ->
                            cityEntity.toCity()
                        }
                    }
                }
        }
    }

    override fun getAutoCompletedCities(city: String): Flowable<ResultWrapper<Exception, List<CityAutoComplete>?>> {
        return remoteDataSource.getAutoCompletedCities(city)
            .map { response ->
                if (response.isSuccessful.not()) {
                    ResultWrapper.build {
                        throw Exception(response.getApiErrorWeather()?.message)
                    }
                }
                response.body() ?: throw throw Exception("Response is null")
            }
            .map { list ->
                ResultWrapper.build {
                    list.map {
                        it.toCityAutoComplete()
                    }
                }
            }
    }
}
