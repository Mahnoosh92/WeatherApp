package com.mahdavi.weatherapp.ui.auth.login

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.ui.auth.AuthActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthActivityTest {


    @Test
    fun test() {
        ActivityScenario.launch(AuthActivity::class.java)

        onView(withId(R.id.create_account)).perform(click())
    }
}