package com.mahdavi.weatherapp.ui.splash

import android.annotation.SuppressLint
import com.mahdavi.weatherapp.data.repository.user.UserRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val DELAY_300_MS = 300L

class SplashPresenter @Inject constructor(
    private val userRepository: UserRepository,
    @IoSchedulers private val ioScheduler: Scheduler,
    @MainSchedulers private val mainScheduler: Scheduler
) :
    SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: SplashContract.View? = null

    @SuppressLint("CheckResult")
    override fun getUserStatus() {
        Flowable.timer(DELAY_300_MS, TimeUnit.MILLISECONDS)
            .flatMap {
                Flowable.just(true)
            }
            .flatMap {
                userRepository.getUserAuthState().toFlowable()
            }
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe({ state ->
                if (state){
                    view?.navigateToDashboard()
                } else {
                    view?.navigateToAuth()
                }
            }, { error ->
                error.message?.let { message ->
                    view?.showError(message)
                }
            }, {/* NO-OP */ }
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