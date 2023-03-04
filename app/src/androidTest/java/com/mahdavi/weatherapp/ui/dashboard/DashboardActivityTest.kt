package com.mahdavi.weatherapp.ui.dashboard

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.util.clickOnViewChild
import com.mahdavi.weatherapp.util.setTextInTextView
import com.mahdavi.weatherapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DashboardActivityTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(DashboardActivity::class.java)

    /**
     * Idling resources tell Espresso that the app is idle or busy. This is needed when operations
     * are not scheduled in the main Looper (for example when executed on a different thread).
     */
    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun get_top_cities_and_scroll_to_position() {
        // Should show top cities and scroll down to position
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15))

        // Should navigate to details screen
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                15,
                clickOnViewChild(R.id.card_view_top_cities)
            )
        )
    }

    @Test
    fun test_bottom_navigation_to_weather() {
        onView(withId(R.id.weather)).perform(click())
    }
    @Test
    fun test_city_autocomplete() {
        onView(withId(R.id.weather)).perform(click())
        onView(withId(R.id.search_edit_text)).perform(click())

        onView(withId(R.id.search_text_city)).perform(setTextInTextView("guil"))

        onView(withId(R.id.recycleview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                clickOnViewChild(R.id.cityName)
            )
        )
    }
}