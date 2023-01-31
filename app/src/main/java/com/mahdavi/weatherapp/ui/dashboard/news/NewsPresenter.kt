package com.mahdavi.weatherapp.ui.dashboard.news

import androidx.annotation.MainThread
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.data.repository.news.NewsRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import java.lang.Exception
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    @IoSchedulers private val ioScheduler: Scheduler,
    @MainThread private val mainScheduler: Scheduler
) : NewsContract.Presenter {

    private var view: NewsContract.View? = null
    override fun getNews(page_size: Int){
        newsRepository.getNews(page_size)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
    }

    override fun detachView(view: NewsContract.View) {

    }

    override fun attachView(view: NewsContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}