package com.mahdavi.weatherapp.ui.auth.register

import com.google.firebase.auth.PhoneAuthCredential
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SignUpWithPhonePresenter @Inject constructor(private val authRepository: AuthRepository) :
    SignUpWithPhoneContract.Presenter {

    private var view: SignUpWithPhoneContract.View? = null
    val compositeDisposable = CompositeDisposable()
    override fun signUp(credential: PhoneAuthCredential) {
        val disposable = authRepository.signInWithPhoneCredential(credential)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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
    }

    override fun attachView(view: SignUpWithPhoneContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}