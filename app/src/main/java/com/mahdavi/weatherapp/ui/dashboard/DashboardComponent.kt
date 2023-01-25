package com.mahdavi.weatherapp.ui.dashboard

import com.mahdavi.weatherapp.di.ActivityScope
import com.mahdavi.weatherapp.ui.dashboard.home.HomeFragment
import com.mahdavi.weatherapp.ui.dashboard.news.NewsFragment
import com.mahdavi.weatherapp.ui.dashboard.settings.SettingsFragment
import com.mahdavi.weatherapp.ui.dashboard.weather.WeatherFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface DashboardComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardComponent
    }

    fun inject(activity: DashboardActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: WeatherFragment)
    fun inject(fragment: NewsFragment)
    fun inject(fragment: SettingsFragment)
}