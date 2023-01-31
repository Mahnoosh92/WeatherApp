package com.mahdavi.weatherapp.ui.dashboard.weather

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.databinding.FragmentWeatherBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.weather.adapter.ForecastDayAdapter
import com.mahdavi.weatherapp.ui.dashboard.weather.click.ClickListener
import com.mahdavi.weatherapp.utils.extensions.getQueryTextChange
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
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

    private var _adapter: ArrayAdapter<String>? = null

    private val forecastDayAdapter: ForecastDayAdapter by lazy {
        ForecastDayAdapter(this)
    }

    private var currentCity: List<CityAutoComplete>? = null

    private var autoCompleteCities: List<CityAutoComplete>? = null

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
        /*NO_OP*/
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        /*NO_OP*/
    }

    override fun setupListeners() {
        binding.apply {
            presenter.getAutoCompleteCities(search.getQueryTextChange())
            search.setOnItemClickListener { _, _, position, _ ->
                val value = _adapter?.getItem(position) ?: ""
                currentCity = autoCompleteCities?.filter { city ->
                    city.localizedName == value
                }
                if (currentCity.isNullOrEmpty().not()) {
                    presenter.getForecastData(currentCity?.first()?.key.toString(), 0)
                }
            }
            OneDay.observableClickListener()
                .debounce(300, TimeUnit.MILLISECONDS)
                .subscribe {
                    presenter.getForecastData(currentCity?.first()?.key.toString(), 0)
                }.also {
                    compositeDisposable.add(it)
                }
            FiveDay.observableClickListener()
                .debounce(300, TimeUnit.MILLISECONDS)
                .subscribe {
                    presenter.getForecastData(currentCity?.first()?.key.toString(), 1)
                }.also {
                    compositeDisposable.add(it)
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
        with(binding) {
            if (forecastTypesContainer.isVisible.not()) {
                forecastTypesContainer.isVisible = true
            }
            loading.visibility = View.GONE
        }
    }

    override fun hideChips() {
        with(binding) {
            if (forecastTypesContainer.isVisible) {
                forecastTypesContainer.isVisible = false
            }
            loading.visibility = View.VISIBLE
        }
    }


    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun populateAutoCompleteData(cities: List<CityAutoComplete>?) {
        autoCompleteCities = cities
        val list = ArrayList<String>()
        cities?.let {
            it.map { cityAutoComplete ->
                if (!list.contains(cityAutoComplete.localizedName)) list.add(
                    cityAutoComplete.localizedName
                )
            }
            this._adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
            binding.search.setAdapter(_adapter)
            _adapter?.setNotifyOnChange(true)
//            binding.search?.showDropDown()
        }
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