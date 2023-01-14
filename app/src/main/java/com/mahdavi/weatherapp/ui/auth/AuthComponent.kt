package com.mahdavi.weatherapp.ui.auth

import com.mahdavi.weatherapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(activity: AuthActivity)
}