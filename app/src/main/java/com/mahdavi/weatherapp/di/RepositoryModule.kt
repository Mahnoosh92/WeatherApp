package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.data.repository.city.DefaultCityRepository
import com.mahdavi.weatherapp.data.repository.user.DefaultUserRepository
import com.mahdavi.weatherapp.data.repository.user.UserRepository
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import com.mahdavi.weatherapp.data.repository.user.authentication.DefaultAuthRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCityRepository(defaultCityRepository: DefaultCityRepository): CityRepository

    @Binds
    abstract fun bindAuthGoogleRepository(defaultAuthGoogleRepository: DefaultAuthRepository): AuthRepository


    @Binds
    abstract fun bindUserRepository(defaultUserRepository: DefaultUserRepository): UserRepository
}