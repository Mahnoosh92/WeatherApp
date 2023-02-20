package com.mahdavi.weatherapp.ui.dashboard.weather.callback

import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCityAutoComplete

interface SearchClickListener {
    fun onCityClicked(cityAutoComplete: CityAutoComplete)
}