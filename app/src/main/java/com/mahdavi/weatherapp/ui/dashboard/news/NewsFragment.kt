package com.mahdavi.weatherapp.ui.dashboard.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.FragmentHomeBinding
import com.mahdavi.weatherapp.databinding.FragmentNewsBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import javax.inject.Inject


class NewsFragment : BaseFragment(), NewsContract.View {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: NewsContract.Presenter

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
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }
}