package com.mahdavi.weatherapp

import android.app.Application
import com.mahdavi.weatherapp.di.AppComponent
import com.mahdavi.weatherapp.di.DaggerAppComponent

open class MyApp : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}