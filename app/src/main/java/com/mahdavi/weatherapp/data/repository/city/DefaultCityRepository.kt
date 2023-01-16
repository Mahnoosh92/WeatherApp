package com.mahdavi.weatherapp.data.repository.city

import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.utils.extensions.getApiError
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultCityRepository @Inject constructor(private val dataSource: CityDataSource) :
    CityRepository {
    override fun getTopCities(size: Int): Flowable<ResultWrapper<Exception, List<City>?>> {
        val behaviourProcessor = BehaviorProcessor.create<ResultWrapper<Exception, List<City>?>>()
        dataSource.getTopCities(size)
            .doOnSuccess {
                behaviourProcessor.onNext(ResultWrapper.build { it.body() })
            }
            .doOnError {
                behaviourProcessor.onNext(ResultWrapper.build { throw it })
            }
            .subscribeOn(Schedulers.io())
            .subscribe()
        return behaviourProcessor
    }

}