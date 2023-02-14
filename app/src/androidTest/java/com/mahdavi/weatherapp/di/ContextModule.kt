package com.mahdavi.weatherapp.di

import androidx.test.platform.app.InstrumentationRegistry
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    fun provideContext() = InstrumentationRegistry.getInstrumentation().targetContext
}