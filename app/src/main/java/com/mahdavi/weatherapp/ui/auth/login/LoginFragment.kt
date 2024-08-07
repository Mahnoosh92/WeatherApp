package com.mahdavi.weatherapp.ui.auth.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayoutMediator
import com.mahdavi.weatherapp.R


import com.mahdavi.weatherapp.databinding.FragmentLoginBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.auth.login.adapter.LoginPageAdapter
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.utils.EspressoIdlingResource
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject


private const val NUM_PAGES = 3

class LoginFragment : BaseFragment(), LoginContract.View {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val compositeDisposable = CompositeDisposable()
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                val credential = GoogleSignIn.getSignedInAccountFromIntent(data)
                presenter.handleSignInResult(credential)
            }
        }

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as AuthActivity).authComponent.inject(this)
    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupUi() {
        val onBoardingAdapter = LoginPageAdapter(this, NUM_PAGES)
        binding.viewpager.apply {
            adapter = onBoardingAdapter
        }
        with(binding) {
            TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                //Some implementation
            }.attach()
        }
    }

    override fun setupSubscribers() {

    }

    override fun setupListeners() {
        this.binding.createAccount.observableClickListener().subscribe({ onNext ->
            (activity as AuthActivity).navigateToLoginWithPhone()
        }, { onError ->

        }, {

        }).also {
            compositeDisposable.add(it)
        }
        binding.apply {
            googleAccount.setOnClickListener {
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.web_client_id))
                    .requestEmail().build()
                val googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
                val signInIntent = googleSignInClient.signInIntent
                resultLauncher.launch(signInIntent)
            }
        }
    }

    override fun showLoader() {
        /*NO_OP*/
    }

    override fun hideLoader() {
        /*NO_OP*/
    }

    override fun showError(message: String) {
        binding.root.shortSnackBar(message)
    }

    override fun navigateToDashboard() {
        (activity as AuthActivity).navigateToHome()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroy()
        compositeDisposable.clear()
    }
}