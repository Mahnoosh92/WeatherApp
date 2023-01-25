package com.mahdavi.weatherapp.ui.auth.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView

interface LoginContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()
    }

    interface Presenter : BasePresenter<View> {
        fun handleSignInResult(completedTask: Task<GoogleSignInAccount>)
    }
}