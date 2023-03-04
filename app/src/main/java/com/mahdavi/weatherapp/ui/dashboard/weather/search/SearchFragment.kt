package com.mahdavi.weatherapp.ui.dashboard.weather.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.databinding.FragmentSearchBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.weather.adapter.SearchbarAdapter
import com.mahdavi.weatherapp.ui.dashboard.weather.callback.SearchClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import javax.inject.Inject


class SearchFragment : BaseFragment(), SearchContract.View, SearchClickListener {

    companion object {
        const val KEY_CITY = "key_city"
        const val KEY_RESULT = "key_result"
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: SearchContract.Presenter
    override fun setupUi() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        /*NO_OP*/
    }

    override fun setupListeners() {
        presenter.getAutoCompleteCities(binding.searchTextCity.getTextOnChange())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showLoader() {
        /*NO_OP*/
    }

    override fun hideLoader() {
        /*NO_OP*/
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun populateAutoCompleteData(cities: List<CityAutoComplete>?) {
        val adapter = SearchbarAdapter(this)
        binding.recycleview.adapter = adapter
        adapter.submitList(cities)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroy()
    }

    override fun onCityClicked(cityAutoComplete: CityAutoComplete) {
        val resultBundle = Bundle().apply { putParcelable(KEY_RESULT, cityAutoComplete) }
        setFragmentResult(KEY_CITY, resultBundle)
        (activity as DashboardActivity).navigateBack()
    }
}