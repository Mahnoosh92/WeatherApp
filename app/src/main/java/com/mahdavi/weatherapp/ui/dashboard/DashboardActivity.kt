package com.mahdavi.weatherapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationBarView
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.databinding.ActivityDashboardBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity

import com.mahdavi.weatherapp.ui.base.BaseActivity
import com.mahdavi.weatherapp.ui.dashboard.home.HomeFragment
import com.mahdavi.weatherapp.ui.dashboard.news.NewsFragment
import com.mahdavi.weatherapp.ui.dashboard.settings.SettingsFragment
import com.mahdavi.weatherapp.ui.dashboard.weather.WeatherFragment
import com.mahdavi.weatherapp.ui.details.DetailsActivity
import com.mahdavi.weatherapp.utils.extensions.addFragment
import com.mahdavi.weatherapp.utils.extensions.replaceFragment
import javax.inject.Inject


class DashboardActivity : BaseActivity(), DashboardContract.View {

    private lateinit var binding: ActivityDashboardBinding
    lateinit var dashboardComponent: DashboardComponent


    @Inject
    lateinit var presenter: DashboardContract.Presenter

    private val mOnItemSelectedListener = NavigationBarView.OnItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.home -> {
                replaceFragment(HomeFragment(), binding.mainContainer.id, false)
                return@OnItemSelectedListener true
            }
            R.id.weather -> {
                replaceFragment(WeatherFragment(), binding.mainContainer.id, false)
                return@OnItemSelectedListener true
            }
            R.id.news -> {
                replaceFragment(NewsFragment(), binding.mainContainer.id, false)
                return@OnItemSelectedListener true
            }
            R.id.settings -> {
                replaceFragment(SettingsFragment(), binding.mainContainer.id, false)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun setupUi() {

    }

    override fun setupSubscribers() {

    }

    override fun setupListeners() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        dashboardComponent = (application as MyApp).appComponent.dashboardComponent().create()
        dashboardComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        replaceFragment(HomeFragment(), binding.mainContainer.id, true)

        with(binding) {
            setSupportActionBar(toolbar)
            bottomNavView.setOnItemSelectedListener(mOnItemSelectedListener)
        }
        manageFragments()
    }

    private fun manageFragments() {

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

    override fun navigateToDetails(city: City) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY_CITY, city)
        startActivity(intent)
    }
}