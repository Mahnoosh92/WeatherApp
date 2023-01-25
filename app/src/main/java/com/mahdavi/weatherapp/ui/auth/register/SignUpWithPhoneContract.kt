package com.mahdavi.weatherapp.ui.auth.register

import com.google.firebase.auth.PhoneAuthCredential
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface SignUpWithPhoneContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
        fun navigateToHome()
        fun showErrors(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun signUp(credential: PhoneAuthCredential)
    }
}