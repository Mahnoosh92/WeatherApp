package com.mahdavi.weatherapp.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.ActivityOnBoardingBinding
import com.mahdavi.weatherapp.ui.onboarding.splash.SplashFragment
import com.mahdavi.weatherapp.utils.extensions.addFragment
import com.mahdavi.weatherapp.utils.extensions.replaceFragment

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(SplashFragment(), binding.container.id, false)
    }

    fun navigateToSplash() {
        replaceFragment(SplashFragment(), binding.container.id, true)
    }
}