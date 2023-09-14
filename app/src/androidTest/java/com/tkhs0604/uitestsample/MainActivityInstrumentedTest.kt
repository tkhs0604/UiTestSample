package com.tkhs0604.uitestsample

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.tkhs0604.uitestsample.featureflag.FeatureFlagProvider
import com.tkhs0604.uitestsample.page.MainPage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainActivityInstrumentedTest {

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
        MainPage
            .clickNavigationButton(featureFlagProvider.shouldUseComposeScreen())
            .assertScreenName()
    }
}
