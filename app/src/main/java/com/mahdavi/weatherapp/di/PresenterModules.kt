package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.ui.splash.SplashContract
import com.mahdavi.weatherapp.ui.splash.SplashPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModules {

    @Binds
    abstract fun bindSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter
}