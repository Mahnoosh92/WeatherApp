package com.mahdavi.weatherapp.ui.auth.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthActivityTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(AuthActivity::class.java)


    @Test
    fun create_account_using_phone_number_flow() {
        // Should be on LoginFragment
        onView(withId(R.id.create_account)).perform(click())

        // Should be on SignUpWithPhoneFragment
        onView(withId(R.id.phone_number)).perform(typeText("7842117255"), closeSoftKeyboard())
        onView(withId(R.id.login)).perform(click())





    }
}