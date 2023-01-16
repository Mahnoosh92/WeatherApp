package com.mahdavi.weatherapp.ui.auth.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.tabs.TabLayoutMediator
import com.mahdavi.weatherapp.databinding.FragmentLoginBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.auth.login.adapter.LoginPageAdapter
import com.mahdavi.weatherapp.ui.base.BaseFragment
import javax.inject.Inject


private const val NUM_PAGES = 3

class LoginFragment : BaseFragment(), LoginContract.View {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                val credential = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(credential)
            }
        }

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as AuthActivity).authComponent.inject(this)
    }

    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val xx = 1
            // Signed in successfully, show authenticated UI.
            // TODO
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.statusCode)
            //TODO
        }
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

    override fun setupObservers() {

    }

    override fun setupListeners() {
        binding.apply {
            googleAccount.setOnClickListener {
                val googleSignInClient =
                    GoogleSignIn.getClient(requireActivity(), presenter.getGoogleSignInOptions())
                val signInIntent = googleSignInClient.signInIntent
                resultLauncher.launch(signInIntent)
            }
        }
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun navigateToRegister() {

    }

    override fun navigateToHome() {

    }

}