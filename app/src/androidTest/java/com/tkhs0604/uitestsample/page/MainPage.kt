package com.tkhs0604.uitestsample.page

import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.tkhs0604.uitestsample.MainActivity

object MainPage {

    lateinit var composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>

    // region components
    private val button
        get() = composeTestRule.onNodeWithText("Go to next activity")
    // endregion

    // region actions
    fun clickButton(isComposeScreen: Boolean): TransitionTargetPage = TransitionTargetPage.get(isComposeScreen).apply {
        button.performClick()
    }
    // endregion
}
