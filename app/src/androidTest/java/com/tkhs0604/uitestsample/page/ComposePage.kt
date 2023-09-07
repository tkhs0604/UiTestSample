package com.tkhs0604.uitestsample.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.tkhs0604.uitestsample.ComposeActivity

object ComposePage : TransitionTargetPage {

    lateinit var composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<ComposeActivity>, ComposeActivity>

    // region components
    private val screenNameLabel
        get() = composeTestRule.onNodeWithText("ComposeActivity")

    private val counterLabel
        get() = composeTestRule.onNodeWithText("count:", substring = true)

    private val countUpButton
        get() = composeTestRule.onNodeWithText("count up")
    // endregion

    // region actions
    override fun clickCountUpButton() = this.apply {
        countUpButton.performClick()
    }

    // endregion

    // region assertions
    override fun assertScreenName() = this.apply {
        screenNameLabel.assertIsDisplayed()
    }

    override fun assertCounterLabel(expected: Int) = this.apply {
        counterLabel.assertTextEquals("count: $expected")
    }
    // endregion
}
