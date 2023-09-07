package com.tkhs0604.uitestsample

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tkhs0604.uitestsample.featureflag.FeatureFlagProvider
import com.tkhs0604.uitestsample.page.MainPage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var featureFlagProvider: FeatureFlagProvider

    @Before
    fun setUp() {
        MainPage.composeTestRule = composeTestRule
        hiltRule.inject()
    }

    @Test
    fun navigationTest() {
        composeTestRule.onNodeWithText("Go to next activity").performClick()

        if (featureFlagProvider.shouldUseComposeScreen()) {
            composeTestRule.onNodeWithText("ComposeActivity").assertIsDisplayed()
        } else {
            Espresso.onView(ViewMatchers.withText("AndroidViewActivity"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun navigationTestByUsingPageObject() {
        MainPage
            .clickButton(featureFlagProvider.shouldUseComposeScreen())
            .assertScreenName()
    }
}
