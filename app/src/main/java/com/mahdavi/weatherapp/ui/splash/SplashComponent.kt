package com.mahdavi.weatherapp.ui.splash

import com.mahdavi.weatherapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun inject(activity: SplashActivity)
}