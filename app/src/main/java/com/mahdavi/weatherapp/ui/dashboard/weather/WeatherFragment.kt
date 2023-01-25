package com.mahdavi.weatherapp.ui.dashboard.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.databinding.FragmentWeatherBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import javax.inject.Inject


class WeatherFragment : BaseFragment(), WeatherContract.View {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: WeatherContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun setupUi() {

    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {

    }

    override fun setupListeners() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }
}