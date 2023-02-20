package com.mahdavi.weatherapp.ui.details

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DetailsPresenter @Inject constructor() : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    override fun setUpLoader(loader: Boolean) {
        Flowable.timer(500, TimeUnit.MILLISECONDS)
            .flatMap {
                Flowable.just(true)
            }
            .subscribe({
                if (loader) {
                    view?.showLoader()
                } else {
                    view?.hideLoader()
                }
            }, {}, {}).also {
                compositeDisposable.add(it)
            }
    }

    override fun detachView(view: DetailsContract.View) {
        this.view = null
    }

    override fun attachView(view: DetailsContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}