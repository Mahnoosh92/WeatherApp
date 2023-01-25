package com.mahdavi.weatherapp.ui.dashboard.home

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val cityRepository: CityRepository,
    @IoSchedulers private val ioSchedulers: Scheduler,
    @MainSchedulers private val mainSchedulers: Scheduler
) : HomeContract.Presenter {

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private var view: HomeContract.View? = null

    override fun getCities(size: Int, update: Boolean) {
        view?.showLoader()
        cityRepository.getTopCities(size, update).subscribeOn(ioSchedulers)
            .observeOn(mainSchedulers).subscribe({ result ->
                when (result) {
                    is ResultWrapper.Value -> {
                        view?.hideLoader()
                        view?.populateData(result.value)
                    }
                    is ResultWrapper.Error -> {
                        view?.showError(result.error.message ?: "Something went wrong")
                    }
                }
            }, { onError ->
                view?.showError(onError.message ?: "Something went wrong!")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun getAutoCompleteCities(city: Flowable<String>) {
        city
            .debounce(500, TimeUnit.MILLISECONDS)
            .switchMap {
                cityRepository.getAutoCompletedCities(it)
            }
            .subscribeOn(ioSchedulers)
            .observeOn(mainSchedulers)
            .subscribe({ result ->
                when (result) {
                    is ResultWrapper.Value -> {
                        view?.populateAutoCompleteData(result.value)
                    }
                    is ResultWrapper.Error -> {
                        view?.showError(result.error.message ?: "something went wrong")
                    }
                }
            }, {
                view?.showError(it.message ?: "something went wrong")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun detachView(view: HomeContract.View) {

    }

    override fun attachView(view: HomeContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}