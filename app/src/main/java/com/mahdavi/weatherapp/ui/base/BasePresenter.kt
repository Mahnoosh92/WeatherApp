package com.mahdavi.weatherapp.ui.base

interface BasePresenter<in V : BaseView> {
    fun detachView(view: V)
    fun attachView(view: V)
    fun destroy()
}