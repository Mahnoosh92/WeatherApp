package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.data.repository.city.DefaultCityRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCityRepository(defaultCityRepository: DefaultCityRepository): CityRepository
}