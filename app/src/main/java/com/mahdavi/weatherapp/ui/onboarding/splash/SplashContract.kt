package com.mahdavi.weatherapp.ui.onboarding.splash

import com.mahdavi.weatherapp.data.model.local.enums.UserStatus
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface SplashContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToOnBoarding()
        fun navigateToAuth()
    }

    interface Presenter : BasePresenter<View> {
        fun getUserStatus(): UserStatus
    }
}