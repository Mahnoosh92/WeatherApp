package com.mahdavi.weatherapp.data.dataSource.remote.forecast

import com.mahdavi.weatherapp.data.api.ApiService
import com.mahdavi.weatherapp.data.model.remote.forcast.RemoteDaysForecast
import com.mahdavi.weatherapp.di.WeatherApiService
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import javax.inject.Inject

class DefaultRemoteForecastDataSource @Inject constructor(@WeatherApiService private val apiService: ApiService) :
    RemoteForecastDataSource {
    override fun getOneDayForecast(key: String): Flowable<Response<RemoteDaysForecast>> = apiService.getOneDayForcast(key)

    override fun getFiveDayForecast(key: String): Flowable<Response<RemoteDaysForecast>> = apiService.getFiveDayForcast(key)

}