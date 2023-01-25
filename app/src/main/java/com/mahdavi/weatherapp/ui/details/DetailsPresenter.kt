package com.mahdavi.weatherapp.ui.details

import javax.inject.Inject

class DetailsPresenter @Inject constructor() : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    override fun setUpLoader(loader: Boolean) {
        if (loader) {
            view?.showLoader()
        } else {
            view?.hideLoader()
        }
    }

    override fun detachView(view: DetailsContract.View) {

    }

    override fun attachView(view: DetailsContract.View) {
        this.view = view
    }

    override fun destroy() {

    }
}