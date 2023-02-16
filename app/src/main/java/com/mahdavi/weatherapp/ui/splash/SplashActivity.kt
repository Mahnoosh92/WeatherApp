package com.mahdavi.weatherapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.databinding.ActivitySplashBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.base.BaseActivity
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
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

    override fun setupSubscribers() {
        /*NO_OP*/
    }

    override fun setupListeners() {
        /*NO_OP*/
    }

    override fun showLoader() {
        /*NO_OP*/
    }

    override fun hideLoader() {
        /*NO_OP*/
    }

    override fun navigateToAuth() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroy()
    }
}