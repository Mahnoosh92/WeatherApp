package com.mahdavi.weatherapp.ui.auth

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface AuthContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToRegister()
        fun navigateToLoginWithPhone()
        fun navigateToLogin()
        fun navigateToHome()
    }

    interface Presenter : BasePresenter<View> {
        fun createAccount()
    }
}