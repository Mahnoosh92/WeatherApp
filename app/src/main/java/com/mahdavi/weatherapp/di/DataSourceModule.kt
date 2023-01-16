package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.DefaultCityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.google.AuthGoogleDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.google.DefaultAuthGoogleDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindCityDataSource(defaultCityDataSource: DefaultCityDataSource): CityDataSource

    @Binds
    abstract fun bindAuthGoogleDataSource(defaultAuthGoogleDataSource: DefaultAuthGoogleDataSource): AuthGoogleDataSource
}