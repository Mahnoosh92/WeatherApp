package com.mahdavi.weatherapp

import com.mahdavi.weatherapp.di.AppComponent
import com.mahdavi.weatherapp.di.DaggerTestAppComponent

/**
 * MyTestApplication will override MyApplication in android tests
 */
class MyTestApplication : MyApp() {

    override fun initializeComponent(): AppComponent {
        // Creates a new TestAppComponent that injects fakes types
        return DaggerTestAppComponent.create()
    }
}