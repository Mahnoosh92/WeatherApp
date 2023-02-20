package com.mahdavi.weatherapp.ui.dashboard.weather.search

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView
import io.reactivex.rxjava3.core.Flowable

interface SearchContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun showError(message: String)
        fun populateAutoCompleteData(cities: List<CityAutoComplete>?)
    }

    interface Presenter : BasePresenter<View> {
        fun getAutoCompleteCities(city: Flowable<String>)
        fun triggerLoader()
    }
}