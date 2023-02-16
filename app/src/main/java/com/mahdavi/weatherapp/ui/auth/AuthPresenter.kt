package com.mahdavi.weatherapp.ui.auth

import javax.inject.Inject

class AuthPresenter @Inject constructor() : AuthContract.Presenter {

    private var view: AuthContract.View? = null
    override fun createAccount() {
        view?.navigateToLogin()
    }

    override fun detachView(view: AuthContract.View) {
        this.view = null
    }

    override fun attachView(view: AuthContract.View) {
        this.view = view
    }

    override fun destroy() {
        /*NO_OP*/
    }
}