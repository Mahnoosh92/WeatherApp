package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.dataSource.local.city.CityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.local.city.DefaultCityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.DefaultCityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.firebase.DefaultFirebaseDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.firebase.FirebaseDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.DefaultUserDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.UserDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.AuthDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.DefaultAuthDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindCityDataSource(defaultCityDataSource: DefaultCityDataSource): CityDataSource

    @Binds
    abstract fun bindAuthGoogleDataSource(defaultAuthGoogleDataSource: DefaultAuthDataSource): AuthDataSource

    @Binds
    abstract fun bindFirebaseDataSource(defaultFirebaseDataSource: DefaultFirebaseDataSource): FirebaseDataSource

    @Binds
    abstract fun bindUserDataSource(defaultUserDataSource: DefaultUserDataSource): UserDataSource

    @Binds
    abstract fun bindCityLocalDataSource(defaultCityLocalDataSource: DefaultCityLocalDataSource): CityLocalDataSource
}