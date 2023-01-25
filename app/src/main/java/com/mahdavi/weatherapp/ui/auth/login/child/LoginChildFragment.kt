package com.mahdavi.weatherapp.ui.auth.login.child

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.FragmentLoginChildBinding
import com.mahdavi.weatherapp.ui.base.BaseFragment


class LoginChildFragment : BaseFragment() {

    private var _binding: FragmentLoginChildBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginChildBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"
        fun getInstance(position: Int) = LoginChildFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    override fun setupUi() {
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingImages = getLoginAssetsLocation()

        with(binding) {
            loginLottie.setAnimation(onBoardingImages[position])
        }
    }

    override fun registerView() {

    }

    override fun setupSubscribers() {

    }

    override fun setupListeners() {

    }

    private fun getLoginAssetsLocation(): List<Int> {
        val onBoardAssets: MutableList<Int> = ArrayList()
        onBoardAssets.add(R.raw.login_slider1)
        onBoardAssets.add(R.raw.login_slider2)
        onBoardAssets.add(R.raw.login_slider3)
        return onBoardAssets
    }

}