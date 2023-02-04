package com.mahdavi.weatherapp.di

import android.content.Context
import com.mahdavi.weatherapp.ui.auth.AuthComponent
import com.mahdavi.weatherapp.ui.dashboard.DashboardComponent
import com.mahdavi.weatherapp.ui.details.DetailsComponent
import com.mahdavi.weatherapp.ui.onboarding.OnBoardingComponent
import com.mahdavi.weatherapp.ui.splash.SplashComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PresenterModules::class,
        PersistenceModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        StorageModule::class,
        NetworkModule::class,
        ThreadingModule::class,
        AppSubcomponents::class,
        FirebaseModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun authComponent(): AuthComponent.Factory
    fun onBoardingComponent(): OnBoardingComponent.Factory
    fun splashComponent(): SplashComponent.Factory
    fun dashboardComponent(): DashboardComponent.Factory
    fun detailsComponent(): DetailsComponent.Factory
}