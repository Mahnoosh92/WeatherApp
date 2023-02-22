package com.mahdavi.weatherapp.ui.auth.register

import com.google.firebase.auth.PhoneAuthCredential
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SignUpWithPhonePresenter @Inject constructor(
    private val authRepository: AuthRepository,
    @IoSchedulers private val ioSchedulers: Scheduler,
    @MainSchedulers private val mainSchedulers: Scheduler
) : SignUpWithPhoneContract.Presenter {

    private var view: SignUpWithPhoneContract.View? = null
    val compositeDisposable = CompositeDisposable()
    override fun signUp(credential: PhoneAuthCredential) {
        val disposable = authRepository.signInWithPhoneCredential(credential)
            .subscribeOn(ioSchedulers)
            .observeOn(mainSchedulers)
            .subscribe(
                {
                    view?.navigateToHome()
                }, {
                    view?.showErrors(it.message ?: "Something went wrong!")
                }
            )
        compositeDisposable.add(disposable)
    }

    override fun detachView(view: SignUpWithPhoneContract.View) {
        this.view = null
    }

    override fun attachView(view: SignUpWithPhoneContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}