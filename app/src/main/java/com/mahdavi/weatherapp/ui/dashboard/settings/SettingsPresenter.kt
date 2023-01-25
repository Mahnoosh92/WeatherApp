package com.mahdavi.weatherapp.ui.dashboard.settings

import com.mahdavi.weatherapp.data.repository.user.UserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SettingsPresenter @Inject constructor(private val userRepository: UserRepository) :
    SettingsContract.Presenter {

    private var view: SettingsContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun signOut() {
        compositeDisposable.add(
            userRepository.signOut()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        view?.navigateToAuth()
                    }, { onError ->
                        view?.showError(onError.message ?: "")
                    }
                )
        )
    }

    override fun detachView(view: SettingsContract.View) {

    }

    override fun attachView(view: SettingsContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}