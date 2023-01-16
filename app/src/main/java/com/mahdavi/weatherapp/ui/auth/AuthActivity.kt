package com.mahdavi.weatherapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.ActivityAuthBinding
import com.mahdavi.weatherapp.ui.auth.login.LoginFragment
import com.mahdavi.weatherapp.ui.splash.SplashComponent
import com.mahdavi.weatherapp.utils.extensions.addFragment

class AuthActivity : AppCompatActivity() {
    lateinit var authComponent: AuthComponent

    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        authComponent = (application as MyApp).appComponent.authComponent().create()
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(LoginFragment(), binding.container.id, true)
    }
}