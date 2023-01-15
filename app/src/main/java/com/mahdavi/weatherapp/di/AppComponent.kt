package com.mahdavi.weatherapp.di

import android.content.Context
import com.mahdavi.weatherapp.ui.auth.AuthComponent
import com.mahdavi.weatherapp.ui.onboarding.OnBoardingComponent
import com.mahdavi.weatherapp.ui.splash.SplashComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PresenterModules::class,
        DataSourceModule::class,
        RepositoryModule::class,
        StorageModule::class,
        NetworkModule::class,
        AppSubcomponents::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun authComponent(): AuthComponent.Factory
    fun onBoardingComponent(): OnBoardingComponent.Factory
    fun splashComponent(): SplashComponent.Factory
}