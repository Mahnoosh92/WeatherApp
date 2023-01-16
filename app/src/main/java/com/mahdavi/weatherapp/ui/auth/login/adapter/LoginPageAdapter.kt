package com.mahdavi.weatherapp.ui.auth.login.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mahdavi.weatherapp.ui.auth.login.child.LoginChildFragment

class LoginPageAdapter (fragment: Fragment, private val itemsCount: Int) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = itemsCount

    override fun createFragment(position: Int) = LoginChildFragment.getInstance(position)
}