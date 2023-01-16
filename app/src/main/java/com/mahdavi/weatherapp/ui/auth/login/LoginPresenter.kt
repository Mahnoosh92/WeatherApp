package com.mahdavi.weatherapp.ui.auth.login

import com.mahdavi.weatherapp.data.repository.user.authentication.google.AuthGoogleRepository
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authGoogleRepository: AuthGoogleRepository) : LoginContract.Presenter {

    override fun getGoogleSignInOptions() = authGoogleRepository.getGoogleSignInOptions()

    override fun detachView(view: LoginContract.View) {

    }

    override fun attachView(view: LoginContract.View) {

    }

    override fun destroy() {

    }
}