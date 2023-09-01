package com.tkhs0604.uitestsample.page

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.tkhs0604.uitestsample.R

object AndroidViewPage {
    private val counterLabel
        get() = Espresso.onView(ViewMatchers.withId(R.id.counter_label))

    private val countUpButton
        get() = Espresso.onView(ViewMatchers.withId(R.id.count_up_button))

    private val screenNameLabel
        get() = Espresso.onView(ViewMatchers.withId(R.id.screen_name_label))

    fun clickCountUpButton() = apply {
        countUpButton.perform(ViewActions.click())
    }

    fun assertCounterLabel(expected: Int) = apply {
        counterLabel.check(ViewAssertions.matches(ViewMatchers.withText("count: $expected")))
    }

    fun assertScreenName() = apply {
        screenNameLabel.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
