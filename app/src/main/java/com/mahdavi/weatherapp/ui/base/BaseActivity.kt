package com.mahdavi.weatherapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun setupUi()
    abstract fun setupSubscribers()
    abstract fun setupListeners()
    override fun onStart() {
        super.onStart()
        setupUi()
        setupListeners()
        setupSubscribers()
    }
}