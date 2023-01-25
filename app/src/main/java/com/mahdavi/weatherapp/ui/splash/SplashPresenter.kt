package com.mahdavi.weatherapp.ui.splash

import android.annotation.SuppressLint
import com.mahdavi.weatherapp.data.repository.user.UserRepository
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val userRepository: UserRepository) :
    SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: SplashContract.View? = null


    @SuppressLint("CheckResult")
    override fun getUserStatus() {
        Flowable.timer(300, TimeUnit.MILLISECONDS)
            .flatMap {
                Flowable.just(true)
            }
            .flatMap {
                userRepository.getUserAuthState().toFlowable()
            }
            .map { state->
                if(state) {
                    view?.navigateToDashboard()
                } else {
                    view?.navigateToAuth()
                }
            }
            .subscribeOn(Schedulers.io())
            .subscribe(
                {

                },
                {
                    it.message?.let{
                        view?.showError(it)
                    }
                },
                {

                }
            )
    }

    override fun detachView(view: SplashContract.View) {
        this.view = null
    }

    override fun attachView(view: SplashContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }

}