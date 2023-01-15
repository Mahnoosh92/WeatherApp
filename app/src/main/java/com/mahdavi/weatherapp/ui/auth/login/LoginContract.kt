package com.mahdavi.weatherapp.ui.auth.login

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface LoginContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToRegister()
        fun navigateToHome()
    }

    interface Presenter : BasePresenter<View> {

    }
}