package com.mahdavi.weatherapp.di

import com.mahdavi.weatherapp.BuildConfig
import com.mahdavi.weatherapp.BuildConfig.BASE_URL
import com.mahdavi.weatherapp.data.api.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    @WeatherOkHttpClient
    fun provideWeatherOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
//            .addInterceptor { chain ->
//                val newRequest =
//                    chain.request().newBuilder().addHeader("x-api-key", BuildConfig.API_KEY).build()
//                chain.proceed(newRequest)
//            }
        return if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor).build()
        } else {
            builder.build()
        }
    }

    @Provides
    @Singleton
    @NewsOkHttpClient
    fun provideNewsOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor { chain ->
                val newRequest =
                    chain.request().newBuilder().addHeader("x-api-key", BuildConfig.API_KEY_NEWS).build()
                chain.proceed(newRequest)
            }
        return if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor).build()
        } else {
            builder.build()
        }
    }
    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Singleton
    @Provides
    @WeatherRetrofit
    fun provideWeatherRetrofit(
        @WeatherOkHttpClient okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    @NewsRetrofit
    fun provideNewsRetrofit(
        @NewsOkHttpClient okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .baseUrl(BuildConfig.BASE_URL_NEWS)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    @WeatherApiService
    fun provideWeatherApiService(@WeatherRetrofit retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    @NewsApiService
    fun provideNewsApiService(@NewsRetrofit retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherApiService

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsApiService

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsOkHttpClient