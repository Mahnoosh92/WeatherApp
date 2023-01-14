package com.mahdavi.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.mahdavi.weatherapp.data.db.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(appContext: Context) = Room.databaseBuilder(
        appContext, AppDataBase::class.java, "weather_app_database"
    )
        .fallbackToDestructiveMigration()
        .build()
}