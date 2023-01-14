package com.mahdavi.weatherapp.ui.splash

import com.mahdavi.weatherapp.data.model.local.user.UserStatus
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SplashPresenter : SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: SplashContract.View? = null

    override fun getUserStatus(): UserStatus {
        return UserStatus.NEW_USER
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