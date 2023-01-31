package com.mahdavi.weatherapp.data.repository.forecast

import com.mahdavi.weatherapp.data.dataSource.remote.forecast.RemoteForecastDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.utils.extensions.getApiError
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultForecastRepository @Inject constructor(private val remoteForecastDataSource: RemoteForecastDataSource) :
    ForecastRepository {
    override fun getOneDayForecast(key: String): Flowable<ResultWrapper<Exception, List<DayForecast>?>> {
        return remoteForecastDataSource.getOneDayForecast(key).map { response ->
                if (response.isSuccessful.not()) {
                    ResultWrapper.build {
                        throw Exception(response.getApiError()?.message)
                    }
                } else {
                    ResultWrapper.build {
                        response.body()?.dailyForecasts?.map {
                            it.toDayForecast()
                        }
                    }
                }
            }

    }

    override fun getFiveDayForecast(key: String): Flowable<ResultWrapper<Exception, List<DayForecast>?>> {
        return remoteForecastDataSource.getFiveDayForecast(key).map { response ->
                if (response.isSuccessful.not()) {
                    ResultWrapper.build {
                        throw Exception(response.getApiError()?.message)
                    }
                } else {
                    ResultWrapper.build {
                        response.body()?.dailyForecasts?.map {
                            it.toDayForecast()
                        }
                    }
                }
            }
    }
}