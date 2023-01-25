package com.mahdavi.weatherapp.ui.dashboard.news

import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import javax.inject.Inject

class NewsPresenter @Inject constructor() : NewsContract.Presenter {

    private var view: NewsContract.View? = null

    override fun detachView(view: NewsContract.View) {

    }

    override fun attachView(view: NewsContract.View) {
        this.view = view
    }

    override fun destroy() {

    }
}