package com.mahdavi.weatherapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdavi.weatherapp.databinding.FragmentOnBoardingBinding
import com.mahdavi.weatherapp.ui.onboarding.splash.SplashFragment
import com.mahdavi.weatherapp.utils.extensions.replaceFragment


class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.setOnClickListener{
            (activity as OnBoardingActivity).navigateToSplash()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}