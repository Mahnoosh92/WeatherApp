package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.ui.auth.AuthContract
import com.mahdavi.weatherapp.ui.auth.AuthPresenter
import com.mahdavi.weatherapp.ui.auth.login.LoginContract
import com.mahdavi.weatherapp.ui.auth.login.LoginPresenter
import com.mahdavi.weatherapp.ui.auth.register.SignUpWithPhoneContract
import com.mahdavi.weatherapp.ui.auth.register.SignUpWithPhonePresenter
import com.mahdavi.weatherapp.ui.dashboard.DashboardContract
import com.mahdavi.weatherapp.ui.dashboard.DashboardPresenter
import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import com.mahdavi.weatherapp.ui.dashboard.home.HomePresenter
import com.mahdavi.weatherapp.ui.dashboard.news.NewsContract
import com.mahdavi.weatherapp.ui.dashboard.news.NewsPresenter
import com.mahdavi.weatherapp.ui.dashboard.settings.SettingsContract
import com.mahdavi.weatherapp.ui.dashboard.settings.SettingsPresenter
import com.mahdavi.weatherapp.ui.dashboard.weather.WeatherContract
import com.mahdavi.weatherapp.ui.dashboard.weather.WeatherPresenter
import com.mahdavi.weatherapp.ui.details.DetailsContract
import com.mahdavi.weatherapp.ui.details.DetailsPresenter
import com.mahdavi.weatherapp.ui.splash.SplashContract
import com.mahdavi.weatherapp.ui.splash.SplashPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModules {

    @Binds
    abstract fun bindSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter

    @Binds
    abstract fun bindLoginPresenter(loginPresenter: LoginPresenter): LoginContract.Presenter

    @Binds
    abstract fun bindLoginWithPhonePresenter(loginWithPhonePresenter: SignUpWithPhonePresenter): SignUpWithPhoneContract.Presenter

    @Binds
    abstract fun bindAuthPresenter(authPresenter: AuthPresenter): AuthContract.Presenter

    @Binds
    abstract fun bindDashboardPresenter(dashboardPresenter: DashboardPresenter): DashboardContract.Presenter

    @Binds
    abstract fun bindHomePresenter(homePresenter: HomePresenter): HomeContract.Presenter

    @Binds
    abstract fun bindNewsPresenter(NewsPresenter: NewsPresenter): NewsContract.Presenter

    @Binds
    abstract fun bindWeatherPresenter(weatherPresenter: WeatherPresenter): WeatherContract.Presenter

    @Binds
    abstract fun bindSettingsPresenter(settingsPresenter: SettingsPresenter): SettingsContract.Presenter

    @Binds
    abstract fun bindDetailsPresenter(detailsPresenter: DetailsPresenter): DetailsContract.Presenter
}