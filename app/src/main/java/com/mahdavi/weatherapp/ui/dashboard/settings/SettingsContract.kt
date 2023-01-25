package com.mahdavi.weatherapp.ui.dashboard.settings

import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface SettingsContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToAuth()
        fun showError(message:String)

    }

    interface Presenter : BasePresenter<View> {
        fun signOut()
    }
}