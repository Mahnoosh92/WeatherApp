package com.mahdavi.weatherapp.ui.auth.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.FragmentLoginWithPhoneBinding
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import com.mahdavi.weatherapp.ui.base.BaseFragment
import com.mahdavi.weatherapp.utils.extensions.observableClickListener
import com.mahdavi.weatherapp.utils.extensions.shortSnackBar
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SignUpWithPhoneFragment : BaseFragment(), SignUpWithPhoneContract.View {

    private var _binding: FragmentLoginWithPhoneBinding? = null
    private val binding get() = _binding!!

    val compositeDisposable = CompositeDisposable()

    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken

    @Inject
    lateinit var presenter: SignUpWithPhoneContract.Presenter

    private val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            //without user effort
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            binding.root.shortSnackBar(
                exception.message ?: (resources.getString(R.string.general_error))
            )
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            storedVerificationId = verificationId
            resendToken = token

            binding.apply {
                codeNumber.isVisible = false
                phoneNumber.isVisible = false
                login.isVisible = false
                otpLayout.isVisible = true
            }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as AuthActivity).authComponent.inject(this)
    }

    override fun setupUi() {

    }

    override fun registerView() {
        presenter.attachView(this)
    }

    override fun setupSubscribers() {
        val getVerificationCodeDisposable = binding.login
            .observableClickListener()
            .subscribe(
                { onNext ->
                    sendVerificationCode(binding.codeNumber.selectedCountryCodeWithPlus.toString() + binding.phoneNumber.text.toString())
                },
                { onError ->
                    binding.root.shortSnackBar(
                        onError.message ?: resources.getString(R.string.general_error)
                    )
                },
                {

                }
            )
        compositeDisposable.add(getVerificationCodeDisposable)
        val verifyOTPDisposable = binding.verifyOtp
            .observableClickListener()
            .subscribe(
                { onNext ->
                    binding.apply {
                        verifyVerificationCode(pinview.value)
                    }
                },
                { onError ->
                    binding.root.shortSnackBar(
                        onError.message ?: resources.getString(R.string.general_error)
                    )
                },
                {

                }
            )
        compositeDisposable.add(verifyOTPDisposable)
    }

    override fun setupListeners() {

    }

    private fun verifyVerificationCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
        presenter.signUp(credential)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginWithPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun navigateToHome() {
        (requireActivity() as AuthActivity).navigateToHome()
    }

    override fun showErrors(error: String) {
        binding.root.shortSnackBar(error)
    }

    private fun sendVerificationCode(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity() as AuthActivity)                 // Activity (for callback binding)
            .setCallbacks(callback)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}