package com.mahdavi.weatherapp.ui.dashboard.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.databinding.FragmentHomeBinding
import com.mahdavi.weatherapp.databinding.FragmentNewsBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject


class NewsFragment : BaseFragment(), NewsContract.View {

    @Inject
    lateinit var presenter: NewsContract.Presenter

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
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
        /*NO_OP*/
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

    override fun populateNews(news: List<Article>) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
        _binding = null
        compositeDisposable.clear()
    }
}