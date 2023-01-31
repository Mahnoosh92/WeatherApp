package com.mahdavi.weatherapp.ui.dashboard.weather

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.data.repository.city.CityRepository
import com.mahdavi.weatherapp.data.repository.forecast.ForecastRepository
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.di.MainSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherPresenter @Inject constructor(
    @IoSchedulers private val ioSchedulers: Scheduler,
    @MainSchedulers private val mainSchedulers: Scheduler,
    private val cityRepository: CityRepository,
    private val forecastRepository: ForecastRepository
) : WeatherContract.Presenter {

    private var view: WeatherContract.View? = null

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun detachView(view: WeatherContract.View) {
        this.view = null
    }

    override fun getAutoCompleteCities(city: Flowable<String>) {
        city.observeOn(mainSchedulers)
            .filter {
                if (it.isEmpty()) {
                    view?.hideChips()
                    view?.showLoader()
                }
                it.isNotEmpty()
            }
            .observeOn(ioSchedulers)
            .debounce(300, TimeUnit.MILLISECONDS)
            .switchMap {
                cityRepository.getAutoCompletedCities(it)
            }
            .subscribeOn(ioSchedulers)
            .observeOn(mainSchedulers)
            .subscribe({ result ->
                when (result) {
                    is ResultWrapper.Value -> {
                        view?.showChips()
                        view?.hideLoader()
                        view?.populateAutoCompleteData(result.value)
                    }
                    is ResultWrapper.Error -> {
                        view?.hideChips()
                        view?.showError(result.error.message ?: "something went wrong")
                    }
                }
            }, {
                view?.showError(it.message ?: "something went wrong")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun getForecastData(key: String, type: Int) {
        if (type == 0) {
            forecastRepository.getOneDayForecast(key)
                .subscribeOn(ioSchedulers)
                .observeOn(mainSchedulers)
                .subscribe({ result ->
                    view?.hideLoader()
                    when (result) {
                        is ResultWrapper.Value -> {
                            view?.populateForecastData(result.value)
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
        } else {
            forecastRepository.getFiveDayForecast(key)
                .subscribeOn(ioSchedulers)
                .observeOn(mainSchedulers)
                .subscribe({ result ->
                    when (result) {
                        is ResultWrapper.Value -> {
                            view?.populateForecastData(result.value)
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
    }

    override fun triggerLoader() {
        view?.showLoader()
    }

    override fun attachView(view: WeatherContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}