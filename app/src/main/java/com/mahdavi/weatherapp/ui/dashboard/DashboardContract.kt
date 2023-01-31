package com.mahdavi.weatherapp.ui.dashboard

import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface DashboardContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToAuth()
        fun navigateToDetails(city: City)

        fun openMobileLinkUrl(url:String)
    }

    interface Presenter : BasePresenter<View> {
    }
}