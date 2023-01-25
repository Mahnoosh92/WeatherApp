package com.mahdavi.weatherapp.ui.dashboard.weather

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface WeatherContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
    }

    interface Presenter : BasePresenter<View> {

    }
}