package com.mahdavi.weatherapp.ui.dashboard.weather

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView
import io.reactivex.rxjava3.core.Flowable

interface WeatherContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()

        fun showChips()

        fun hideChips()
        fun showError(message:String)

        fun populateAutoCompleteData(cities:List<CityAutoComplete>?)
        fun populateForecastData(data:List<DayForecast>?)
    }

    interface Presenter : BasePresenter<View> {
        fun getAutoCompleteCities(city: Flowable<String>)
        fun getForecastData(key:String, type:Int = 0)

        fun triggerLoader()
    }
}