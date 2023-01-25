package com.mahdavi.weatherapp.ui.dashboard

import javax.inject.Inject

class DashboardPresenter @Inject constructor() : DashboardContract.Presenter {

    private var view: DashboardContract.View? = null
    override fun detachView(view: DashboardContract.View) {

    }

    override fun attachView(view: DashboardContract.View) {
        this.view = view
    }

    override fun destroy() {

    }
}