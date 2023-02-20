package com.mahdavi.weatherapp.ui.dashboard.weather.search

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val cityRepository: CityRepository,
    @IoSchedulers private val ioScheduler: Scheduler,
    @MainSchedulers private val mainScheduler: Scheduler
) : SearchContract.Presenter {

    private var view: SearchContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    override fun getAutoCompleteCities(city: Flowable<String>) {
        city
            .concatMap {
                cityRepository.getAutoCompletedCities(it)
            }
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe({ result ->
                when (result) {
                    is ResultWrapper.Error -> {
                        view?.showError(result.error.message.toString())
                    }
                    is ResultWrapper.Value -> {
                        view?.populateAutoCompleteData(result.value)
                    }
                }
            }, {
                view?.showError(it.message ?: "something went wrong")
            }, {})
            .also {
                compositeDisposable.add(it)
            }
    }

    override fun triggerLoader() {
        /*NO_OP*/
    }

    override fun detachView(view: SearchContract.View) {
        this.view = null
    }

    override fun attachView(view: SearchContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}