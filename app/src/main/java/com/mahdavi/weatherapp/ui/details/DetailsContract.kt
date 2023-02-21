package com.mahdavi.weatherapp.ui.details

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface DetailsContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun showError(message: String)
        fun populateDetails()
    }

    interface Presenter : BasePresenter<View> {
        fun setUpLoader(loader: Boolean)
    }
}