package com.mahdavi.weatherapp.ui.dashboard.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.databinding.FragmentNewsBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.news.adapter.NewsAdapter
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.processors.PublishProcessor
import javax.inject.Inject


class NewsFragment : BaseFragment(), NewsContract.View {

    @Inject
    lateinit var presenter: NewsContract.Presenter

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private val newsAdapter: NewsAdapter = NewsAdapter()
    private lateinit var layoutManager: LinearLayoutManager

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private var page = 1
    private var totalItem = 0
    private var lastVisibleItem = 0
    private val visibleThreshold = 1
    private val paginator = PublishProcessor.create<Int>()
    private var loading = false
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
        layoutManager = binding.news.layoutManager as LinearLayoutManager
        presenter.getNews(page_size = page)
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        paginator
            .onBackpressureDrop()
            .doOnNext { page: Int? ->
                page?.let {
                    presenter.getNews(page_size = page)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe().also {
                compositeDisposable.add(it)
            }
    }

    override fun setupListeners() {
        binding.news.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItem = layoutManager.itemCount
                lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (!loading && totalItem <= (lastVisibleItem + visibleThreshold)) {
                    page++
                    paginator.onNext(page)
                }
            }
        })
    }

    override fun showLoader() {
        loading = true
        binding.apply {
            loading.isVisible = true
        }
    }

    override fun hideLoader() {
        loading = false
        binding.apply {
            loading.isVisible = false
        }
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun populateNews(news: List<Article>) {
        newsAdapter.addItems(news)
        binding.news.adapter = newsAdapter
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