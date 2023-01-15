package com.mahdavi.weatherapp.ui.splash

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor() : SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: SplashContract.View? = null

    override fun getUserStatus() {
        compositeDisposable.add(
            Flowable.timer(300, TimeUnit.MILLISECONDS)
                .flatMap {
                    Flowable.just(true)
                }
                .subscribe({ onNext ->
                    view?.navigateToAuth()
                }, { onError ->

                }, {

                })
        )
    }

    override fun detachView(view: SplashContract.View) {
        this.view = null
    }

    override fun attachView(view: SplashContract.View) {
        this.view = view
    }
    override fun destroy() {
        compositeDisposable.clear()
    }

}