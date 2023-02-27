package com.mahdavi.weatherapp.di.fake

import androidx.test.platform.app.InstrumentationRegistry
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    fun provideContext() = InstrumentationRegistry.getInstrumentation().targetContext
}