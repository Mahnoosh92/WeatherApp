package com.mahdavi.weatherapp.ui.dashboard.home.click

import com.mahdavi.weatherapp.data.model.local.cities.City

interface ClickListener {
    fun onClick(city: City)
}