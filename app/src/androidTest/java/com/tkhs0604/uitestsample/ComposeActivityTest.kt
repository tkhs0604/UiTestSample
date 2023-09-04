package com.tkhs0604.uitestsample

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
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
    fun counterTest() = with(composeTestRule) {
        // Given: assert initial count
        onNodeWithText("count: 0").assertIsDisplayed()

        // When: click count up button
        onNodeWithText("count up").performClick()

        // Then: assert that count is incremented
        onNodeWithText("count: 1").assertIsDisplayed()
    }

    @Test
    fun counterTestWithTestTag() = with(composeTestRule) {
        // Given: assert initial count
        onNodeWithTag(ComposeScreenTestTags.COUNTER_LABEL).assertTextEquals("count: 0")

        // When: click count up button
        onNodeWithTag(ComposeScreenTestTags.COUNT_UP_BUTTON).performClick()

        // Then: assert that count is incremented
        onNodeWithTag(ComposeScreenTestTags.COUNTER_LABEL).assertTextEquals("count: 1")
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
            .assertScreenName()
            // When: click navigation button to next screen
            .clickNavigationButton()
            // Given: assert next screen
            .assertScreenNameLabel()
    }
}
