package com.mahdavi.weatherapp.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.FragmentLoginBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment

private const val NUM_PAGES = 5

class LoginFragment : BaseFragment(), LoginContract.View {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUi() {
        with(binding) {
            TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                //Some implementation
            }.attach()
        }
    }

    override fun setupObservers() {

    }

    override fun setupListeners() {

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