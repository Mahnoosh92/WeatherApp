package com.mahdavi.weatherapp.ui.details

import com.mahdavi.weatherapp.di.ActivityScope
import com.mahdavi.weatherapp.ui.splash.SplashActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailsComponent
    }

    fun inject(activity: DetailsActivity)
}