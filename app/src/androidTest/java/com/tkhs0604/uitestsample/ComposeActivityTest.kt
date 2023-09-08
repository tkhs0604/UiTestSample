package com.tkhs0604.uitestsample

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tkhs0604.uitestsample.page.ComposePage
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ComposeActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeActivity>()

    @Before
    fun setUp() {
        ComposePage.composeTestRule = composeTestRule
    }

    @Test
    fun counterTest() = composeTestRule.execute {
        // Given: assert initial count
        onNodeWithText("count: 0").assertIsDisplayed()

        // When: click count up button
        onNodeWithText("count up").performClick()

        // Then: assert that count is incremented
        onNodeWithText("count: 1").assertIsDisplayed()
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

    private fun ComposeTestRule.execute(block: ComposeTestRule.() -> Unit) {
        block(this)
    }
}
