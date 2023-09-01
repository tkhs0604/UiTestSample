package com.tkhs0604.uitestsample.page

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.tkhs0604.uitestsample.ComposeActivity
import com.tkhs0604.uitestsample.R.id
import org.junit.Rule

object ComposePage {

    lateinit var composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<ComposeActivity>, ComposeActivity>

    private val counterLabel
        get() = composeTestRule.onNodeWithText("count:", substring = true)

    private val countUpButton
        get() = composeTestRule.onNodeWithText("count up")

    private val navigationButton
        get() = composeTestRule.onNodeWithText("Go to AndroidViewActivity")

    private val screenNameLabel
        get() = composeTestRule.onNodeWithText("ComposeActivity")

    fun clickCountUpButton() = apply {
        countUpButton.performClick()
    }

    fun assertCounterLabel(expected: Int) = apply {
        counterLabel.assertTextEquals("count: $expected")
    }

    fun assertScreenName() = apply {
        screenNameLabel.assertExists()
    }

    fun clickNavigationButton() = AndroidViewPage.apply {
        navigationButton.performClick()
    }
}
