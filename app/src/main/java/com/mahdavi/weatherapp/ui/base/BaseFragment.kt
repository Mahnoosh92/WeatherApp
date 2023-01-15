package com.mahdavi.weatherapp.ui.base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){
    abstract fun setupUi()
    abstract fun setupObservers()
    abstract fun setupListeners()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        setupUi()
        setupListeners()
        setupObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}