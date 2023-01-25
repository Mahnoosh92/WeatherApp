package com.mahdavi.weatherapp.ui.base

import io.reactivex.rxjava3.disposables.CompositeDisposable

interface BasePresenter<in V : BaseView> {
    fun detachView(view: V)
    fun attachView(view: V)
    fun destroy()
}