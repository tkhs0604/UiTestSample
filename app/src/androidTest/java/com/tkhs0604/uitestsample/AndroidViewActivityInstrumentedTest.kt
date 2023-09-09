package com.tkhs0604.uitestsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.tkhs0604.uitestsample.page.AndroidViewPage
import org.junit.Rule
import org.junit.Test

class AndroidViewActivityInstrumentedTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(AndroidViewActivity::class.java)

    @Test
    fun counterTest() {
        // Given: assert initial count
        Espresso.onView(ViewMatchers.withId(R.id.counter_label))
            .check(ViewAssertions.matches(ViewMatchers.withText("count: 0")))

        // When: click count up button
        Espresso.onView(ViewMatchers.withId(R.id.count_up_button))
            .perform(ViewActions.click())

        // Then: assert that count is incremented
        Espresso.onView(ViewMatchers.withId(R.id.counter_label))
            .check(ViewAssertions.matches(ViewMatchers.withText("count: 1")))
    }

    @Test
    fun counterTestByUsingPageObject() {
        AndroidViewPage
            // Given: assert initial count
            .assertCounterLabel(0)
            // When: click count up button
            .clickCountUpButton()
            // Then: assert that count is incremented
            .assertCounterLabel(1)
    }
}
