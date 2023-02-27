package com.mahdavi.weatherapp.ui.dashboard.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.databinding.FragmentHomeBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.home.adapter.CityAdapter
import com.mahdavi.weatherapp.ui.dashboard.home.click.ClickListener
import com.mahdavi.weatherapp.utils.EspressoIdlingResource
import com.mahdavi.weatherapp.utils.extensions.getQueryTextChange
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View, ClickListener {

    @Inject
    lateinit var presenter: HomeContract.Presenter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val size = 50
    private val adapter: CityAdapter by lazy {
        CityAdapter(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUi() {
        presenter.getCities(size, false)
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        /* NO-OP */
    }

    override fun setupListeners() {
        /* NO-OP */
    }

    override fun showLoader() {
        binding.apply {
            loading?.isVisible = true
            recyclerView?.isVisible = false
        }
    }

    override fun hideLoader() {
        binding.apply {
            loading?.isVisible = false
            recyclerView?.isVisible = true
        }
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun populateData(cities: List<City>?) {
        binding.recyclerView?.adapter = adapter
        adapter.submitList(cities)
    }

    override fun onClick(city: City) {
        (requireActivity() as DashboardActivity).navigateToDetails(city)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView(this)
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}