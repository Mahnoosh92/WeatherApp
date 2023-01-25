package com.mahdavi.weatherapp.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.ActivityOnBoardingBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.splash.SplashActivity
import com.mahdavi.weatherapp.utils.extensions.addFragment
import com.mahdavi.weatherapp.utils.extensions.replaceFragment
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkUserStatus()
        navigateToSplash()

    }

    fun checkUserStatus() {

    }
    fun navigateToSplash() {
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
        finish()
    }
}