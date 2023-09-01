package com.tkhs0604.uitestsample

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tkhs0604.uitestsample.page.ComposePage
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposeActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeActivity>()

    @Before
    fun setUp() {
        ComposePage.composeTestRule = composeTestRule
    }

    @Test
    fun counterTest() {
        // Given: assert initial count
        composeTestRule.onNodeWithText("count: 0").assertExists()

        // When: click count up button
        composeTestRule.onNodeWithText("count up").performClick()

        // Then: assert that count is incremented
        composeTestRule.onNodeWithText("count: 1").assertExists()
    }

    @Test
    fun counterTestByUsingPageObject() {
        ComposePage
            // Given: assert initial count
            .assertCounterLabel(0)
            // When: click count up button
            .clickCountUpButton()
            // Then: assert that count is incremented
            .assertCounterLabel(1)
    }

    @Test
    fun navigationTestByUsingPageObject() {
        ComposePage
            // Given: assert initial screen
            .assertScreen()
            // When: click navigation button to next screen
            .clickNavigationButton()
            // Given: assert next screen
            .assertScreen()
    }
}
