package com.mahdavi.weatherapp.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
object FirebaseModule {
    @Singleton
    @Provides
    fun provideFirebaseAuth() = Firebase.auth

}