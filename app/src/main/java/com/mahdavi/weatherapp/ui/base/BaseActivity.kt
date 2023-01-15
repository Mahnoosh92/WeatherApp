package com.mahdavi.weatherapp.ui.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    abstract fun setupUi()
    abstract fun setupObservers()
    abstract fun setupListeners()
    override fun onStart() {
        super.onStart()

        setupUi()
        setupListeners()
        setupObservers()
    }
}