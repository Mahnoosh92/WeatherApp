package com.mahdavi.weatherapp.ui.dashboard.news

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.repository.news.NewsRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    @IoSchedulers private val ioScheduler: Scheduler,
    @MainSchedulers private val mainScheduler: Scheduler
) : NewsContract.Presenter {
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    private var view: NewsContract.View? = null
    override fun getNews(page: Int) {
        view?.showLoader()
        newsRepository.getNews(page, true)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe({ result ->
                when (result) {
                    is ResultWrapper.Value -> {
                        view?.hideLoader()
                        result.value?.let {
                            view?.populateNews(it)
                        }
                    }
                    is ResultWrapper.Error -> {
                        view?.showError(result.error.message ?: "something went wrong!")
                    }
                }
            }, {
                view?.showError(it.message ?: "something went wrong!")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun detachView(view: NewsContract.View) {
    }

    override fun attachView(view: NewsContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
        compositeDisposable.clear()
    }
}