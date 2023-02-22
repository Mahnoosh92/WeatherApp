package com.mahdavi.weatherapp.ui.dashboard.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.FragmentHomeBinding
import com.mahdavi.weatherapp.databinding.FragmentSettingsBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.ui.dashboard.DashboardActivity
import com.mahdavi.weatherapp.ui.dashboard.home.HomeContract
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SettingsFragment : BaseFragment(), SettingsContract.View {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: SettingsContract.Presenter
    private val compositeDisposable = CompositeDisposable()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as DashboardActivity).dashboardComponent.inject(this)
    }

    override fun setupUi() {
        /*NO_OP*/
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        /*NO_OP*/
    }

    override fun setupListeners() {
        binding.signout
            .observableClickListener()
            .debounce(300, TimeUnit.MILLISECONDS)
            .subscribe {
                presenter.signOut()
            }.also { compositeDisposable.add(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showLoader() {
        /*NO_OP*/
    }

    override fun hideLoader() {
        /*NO_OP*/
    }

    override fun navigateToAuth() {
        (requireActivity() as DashboardActivity).navigateToAuth()
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        presenter.detachView(this)
        presenter.destroy()
    }
}