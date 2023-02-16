package com.mahdavi.weatherapp.di

import androidx.core.content.res.TypedArrayUtils.getString
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mahdavi.weatherapp.R
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