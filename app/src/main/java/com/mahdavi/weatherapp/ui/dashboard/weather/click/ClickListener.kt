package com.mahdavi.weatherapp.ui.dashboard.weather.click

import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast

interface ClickListener {
    fun onClick(dayForecast:DayForecast)
}