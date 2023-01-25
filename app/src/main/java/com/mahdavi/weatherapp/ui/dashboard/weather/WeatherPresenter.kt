package com.mahdavi.weatherapp.ui.dashboard.weather

import javax.inject.Inject

class WeatherPresenter @Inject constructor() : WeatherContract.Presenter {

    private var view: WeatherContract.View? = null
    override fun detachView(view: WeatherContract.View) {

    }

    override fun attachView(view: WeatherContract.View) {
        this.view = view
    }

    override fun destroy() {

    }
}