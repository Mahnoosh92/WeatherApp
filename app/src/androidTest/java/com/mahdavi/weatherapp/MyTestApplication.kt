package com.mahdavi.weatherapp

import androidx.test.platform.app.InstrumentationRegistry
import com.mahdavi.weatherapp.di.AppComponent
import com.mahdavi.weatherapp.di.fake.DaggerTestAppComponent

/**
 * MyTestApplication will override MyApplication in android tests
 */
class MyTestApplication : MyApp() {

    override fun initializeComponent(): AppComponent {
        // Creates a new TestAppComponent that injects fakes types
        return DaggerTestAppComponent.factory().create(InstrumentationRegistry.getInstrumentation().targetContext)
    }
}