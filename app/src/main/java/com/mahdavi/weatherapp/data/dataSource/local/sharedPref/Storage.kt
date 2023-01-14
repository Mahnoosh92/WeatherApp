package com.mahdavi.weatherapp.data.dataSource.local.sharedPref

import com.f2prateek.rx.preferences2.Preference

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): Preference<String>
}