package com.mahdavi.weatherapp.ui.details

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DetailsPresenter @Inject constructor() : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    override fun setUpLoader(loader: Boolean) {
        Flowable.timer(300, TimeUnit.MILLISECONDS)
            .flatMap {
                Flowable.just(loader)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it) {
                    view?.showLoader()
                } else {
                    view?.hideLoader()
                    view?.populateDetails()
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