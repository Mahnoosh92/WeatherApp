package com.mahdavi.weatherapp.ui.auth.login

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authGoogleRepository: AuthRepository,
    @IoSchedulers private val ioScheduler: Scheduler,
    @MainSchedulers private val mainScheduler: Scheduler,
) :
    LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private var compositeDisposable = CompositeDisposable()
    override fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(account)
        } catch (e: ApiException) {
            view?.showError(e.message ?: "something went wrong with firebase")
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        authGoogleRepository.signInWithCredential(account)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe({
                view?.navigateToDashboard()
            }, {
                view?.showError(it.message ?: "something went wrong with firebase")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun detachView(view: LoginContract.View) {
        this.view = null
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}