package com.tkhs0604.uitestsample.page

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.tkhs0604.uitestsample.R

object AndroidViewPage {
    // region components
    private val counterLabel
        get() = Espresso.onView(ViewMatchers.withId(R.id.counter_label))

    private val countUpButton
        get() = Espresso.onView(ViewMatchers.withId(R.id.count_up_button))

    private val screenNameLabel
        get() = Espresso.onView(ViewMatchers.withId(R.id.screen_name_label))
    // endregion

    // region actions
    fun clickCountUpButton() = apply {
        countUpButton.perform(ViewActions.click())
    }
    // endregion

    // region asserts
    fun assertScreenNameLabel() = apply {
        screenNameLabel.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun assertCounterLabel(expected: Int) = apply {
        counterLabel.check(ViewAssertions.matches(ViewMatchers.withText("count: $expected")))
    }
    // endregion
}
