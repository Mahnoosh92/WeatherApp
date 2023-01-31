package com.mahdavi.weatherapp.ui.dashboard.home

import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView
import io.reactivex.rxjava3.core.Flowable

interface HomeContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun showError(message: String)
        fun populateData(cities: List<City>?)
    }

    interface Presenter : BasePresenter<View> {
        fun getCities(size: Int, update: Boolean)
    }
}