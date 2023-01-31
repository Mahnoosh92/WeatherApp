package com.mahdavi.weatherapp.data.dataSource.remote.forecast

import com.mahdavi.weatherapp.data.model.remote.forcast.RemoteDaysForecast
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response

interface RemoteForecastDataSource {
    fun getOneDayForecast(key:String): Flowable<Response<RemoteDaysForecast>>
    fun getFiveDayForecast(key:String): Flowable<Response<RemoteDaysForecast>>
}