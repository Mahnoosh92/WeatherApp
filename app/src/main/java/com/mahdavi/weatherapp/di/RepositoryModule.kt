package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.data.repository.city.DefaultCityRepository
import com.mahdavi.weatherapp.data.repository.user.authentication.google.AuthGoogleRepository
import com.mahdavi.weatherapp.data.repository.user.authentication.google.DefaultAuthGoogleRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCityRepository(defaultCityRepository: DefaultCityRepository): CityRepository

    @Binds
    abstract fun bindAuthGoogleRepository(defaultAuthGoogleRepository: DefaultAuthGoogleRepository): AuthGoogleRepository
}