package com.mahdavi.weatherapp.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.databinding.FragmentOnBoardingBinding
import com.mahdavi.weatherapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment(), SplashContract.View {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoader()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun navigateToOnBoarding() {

    }

    override fun navigateToAuth() {

    }


}