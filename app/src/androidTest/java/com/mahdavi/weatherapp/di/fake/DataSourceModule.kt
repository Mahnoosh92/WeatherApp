package com.mahdavi.weatherapp.di.fake

import com.mahdavi.weatherapp.data.dataSource.local.city.CityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.local.city.DefaultCityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.local.news.DefaultNewsLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.local.news.NewsLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.DefaultCityDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.forecast.DefaultRemoteForecastDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.forecast.RemoteForecastDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.news.DefaultNewsRemoteDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.news.NewsRemoteDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.DefaultUserDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.UserDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.AuthDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindCityDataSource(defaultCityDataSource: DefaultCityDataSource): CityDataSource

    @Binds
    abstract fun bindAuthGoogleDataSource(fakeAuthDataSource: FakeAuthDataSource): AuthDataSource

    @Binds
    abstract fun bindUserDataSource(defaultUserDataSource: DefaultUserDataSource): UserDataSource

    @Binds
    abstract fun bindCityLocalDataSource(defaultCityLocalDataSource: DefaultCityLocalDataSource): CityLocalDataSource

    @Binds
    abstract fun bindForecastRemoteDataSource(dfaultRemoteForecastDataSource: DefaultRemoteForecastDataSource): RemoteForecastDataSource

    @Binds
    abstract fun bindNewsRemoteDataSource(defaultNewsRemoteDataSource: DefaultNewsRemoteDataSource): NewsRemoteDataSource

    @Binds
    abstract fun bindNewsLocalDataSource(defaultNewsLocalDataSource: DefaultNewsLocalDataSource): NewsLocalDataSource

}