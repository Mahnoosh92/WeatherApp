package com.mahdavi.weatherapp.ui.dashboard.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.databinding.FragmentWeatherBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.weather.adapter.ForecastDayAdapter
import com.mahdavi.weatherapp.ui.dashboard.weather.click.ClickListener
import com.mahdavi.weatherapp.ui.dashboard.weather.search.SearchFragment
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import com.mahdavi.weatherapp.widget.searchbar.SearchbarClickedCallback
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class WeatherFragment : BaseFragment(), WeatherContract.View, ClickListener {
    @Inject
    lateinit var presenter: WeatherContract.Presenter

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private val forecastDayAdapter: ForecastDayAdapter by lazy {
        ForecastDayAdapter(this)
    }

    private var currentCity: List<CityAutoComplete>? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUi() {
        setFragmentResultListener(SearchFragment.KEY_CITY) { reqKey, bundle ->
            if (reqKey == SearchFragment.KEY_CITY) {
                val selectedCity = bundle.getParcelable<CityAutoComplete>(SearchFragment.KEY_RESULT)
                binding.searchEditText.text = selectedCity?.localizedName
                presenter.getForecastData(selectedCity?.key ?: "", 0)
            }
        }
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        /*NO_OP*/
    }

    override fun setupListeners() {
        binding.apply {
            search.setOnClickListener {
                (requireActivity() as DashboardActivity).navigateToSearch()
            }

        }
    }

    override fun showLoader() {
        binding.apply {
            loading.isVisible = true
            forecast.isVisible = false
        }
    }

    override fun hideLoader() {
        binding.apply {
            loading.isVisible = false
            forecast.isVisible = true
        }
    }

    override fun showChips() {
        /*NO_OP*/
    }

    override fun hideChips() {
        /*NO_OP*/
    }


    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun populateForecastData(data: List<DayForecast>?) {
        with(binding) {
            forecast.adapter = forecastDayAdapter
            forecastDayAdapter.submitList(data)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        _binding = null
        presenter.destroy()
    }

    override fun onClick(dayForecast: DayForecast) {
        dayForecast.mobileLink?.let {
            (requireActivity() as DashboardActivity).openMobileLinkUrl(it)
        }
    }
}