package com.mahdavi.weatherapp.ui.details

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.mahdavi.weatherapp.MyApp
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.databinding.ActivityDetailsBinding
import com.mahdavi.weatherapp.ui.base.BaseActivity
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsContract.View {

    @Inject
    lateinit var presenter: DetailsContract.Presenter

    companion object {
        const val KEY_CITY = "city"
    }

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var detailsComponent: DetailsComponent

    private val compositeDesposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun setupUi() {
//        setSupportActionBar(binding.toolbar)
        presenter.setUpLoader(true)
        populateDetails()
    }

    private fun populateDetails() {
        val city = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_CITY, City::class.java)
        } else {
            intent.getParcelableExtra(KEY_CITY)
        }
        binding.apply {
            countryValue.text = city?.country
            englishNameValue.text = city?.englishName
            populstionValue.text = city?.details?.population.toString()
            presenter.setUpLoader(false)
        }
    }

    override fun setupSubscribers() {

    }

    override fun setupListeners() {
        binding.back.observableClickListener()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

            }.also {
                compositeDesposable.add(it)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        detailsComponent = (application as MyApp).appComponent.detailsComponent().create()
        detailsComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
    }

    override fun showLoader() {
        binding.apply {
            loading.isVisible = true
            details.isVisible = false
        }
    }

    override fun hideLoader() {
        binding.apply {
            loading.isVisible = false
            details.isVisible = true
        }
    }

    override fun showError(message: String) {

    }
}