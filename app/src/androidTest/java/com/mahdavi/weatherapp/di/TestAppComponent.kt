package com.mahdavi.weatherapp.di

import dagger.Component
import javax.inject.Singleton

// Replacement for AppComponent in android tests
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
        FirebaseModule::class,
        ContextModule::class
    ]
)
interface TestAppComponent : AppComponent
