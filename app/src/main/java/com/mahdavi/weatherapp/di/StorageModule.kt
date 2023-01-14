package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.data.dataSource.local.sharedPref.DefaultStorage
import com.mahdavi.weatherapp.data.dataSource.local.sharedPref.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun bindStorage(storage: DefaultStorage): Storage
}