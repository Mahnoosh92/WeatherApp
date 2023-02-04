package com.mahdavi.weatherapp.data.dataSource.local.sharedPref

import android.content.Context
import com.f2prateek.rx.preferences2.Preference
import com.f2prateek.rx.preferences2.RxSharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

private const val WEATHER_APP_SHARED_PREFERENCES = "weather_app_shared_preferences"

@Singleton
class DefaultStorage @Inject constructor(context: Context) : Storage {

    private val preferences = context.getSharedPreferences(WEATHER_APP_SHARED_PREFERENCES, Context.MODE_PRIVATE)
    private val rxPreferences = RxSharedPreferences.create(preferences)

    override fun setString(key: String, value: String) {
        with(preferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): Preference<String> {
        val result = rxPreferences.getString(key)
        return result
    }
}