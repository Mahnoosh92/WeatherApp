package com.mahdavi.weatherapp.data.repository.forecast

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import io.reactivex.rxjava3.core.Flowable

interface ForecastRepository {
    fun getOneDayForecast(key:String): Flowable<ResultWrapper<Exception,List<DayForecast>?>>
    fun getFiveDayForecast(key:String): Flowable<ResultWrapper<Exception,List<DayForecast>?>>
}