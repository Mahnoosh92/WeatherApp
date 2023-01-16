package com.mahdavi.weatherapp.ui.auth

import com.mahdavi.weatherapp.di.ActivityScope
import com.mahdavi.weatherapp.ui.auth.login.LoginFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(activity: AuthActivity)
    fun inject(fragment: LoginFragment)
}