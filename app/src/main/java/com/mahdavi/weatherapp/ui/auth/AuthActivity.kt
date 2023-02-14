package com.mahdavi.weatherapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.databinding.ActivityAuthBinding
import com.mahdavi.weatherapp.ui.auth.login.LoginFragment
import com.mahdavi.weatherapp.ui.auth.register.SignUpWithPhoneFragment
import com.mahdavi.weatherapp.ui.base.BaseActivity
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.utils.extensions.addFragment
import com.mahdavi.weatherapp.utils.extensions.replaceFragment
import javax.inject.Inject

class AuthActivity : AppCompatActivity(), AuthContract.View {

    lateinit var authComponent: AuthComponent
    private lateinit var binding: ActivityAuthBinding

    @Inject
    lateinit var presenter: AuthContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApp).appComponent.authComponent().create().inject(this)
        authComponent = (application as MyApp).appComponent.authComponent().create()
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.createAccount()
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun navigateToRegister() {

    }

    override fun navigateToLoginWithPhone() {
        replaceFragment(SignUpWithPhoneFragment(), binding.container.id, true)
    }

    override fun navigateToLogin() {
        addFragment(LoginFragment(), binding.container.id, true)
    }

    override fun navigateToHome() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}