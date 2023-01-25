package com.mahdavi.weatherapp.ui.dashboard.news

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface NewsContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
    }

    interface Presenter : BasePresenter<View> {

    }
}