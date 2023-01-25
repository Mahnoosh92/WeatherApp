package com.mahdavi.weatherapp.ui.splash

import com.mahdavi.weatherapp.data.model.local.user.UserStatus
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface SplashContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToAuth()
        fun navigateToDashboard()
        fun showError(message:String)
    }

    interface Presenter : BasePresenter<View> {
        fun getUserStatus()
    }
}