package com.mahdavi.weatherapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.databinding.ActivitySplashBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.base.BaseActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    private lateinit var splashComponent: SplashComponent

    @Inject
    lateinit var presenter: SplashContract.Presenter

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        splashComponent = (application as MyApp).appComponent.splashComponent().create()
        splashComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
    }

    override fun setupUi() {
       presenter.getUserStatus()
    }

    override fun setupObservers() {

    }

    override fun setupListeners() {

    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun navigateToAuth() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroy()
    }
}