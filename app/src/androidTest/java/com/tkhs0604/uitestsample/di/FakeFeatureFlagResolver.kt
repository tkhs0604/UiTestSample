package com.tkhs0604.uitestsample.di

import com.tkhs0604.uitestsample.FeatureFlagProvider
import javax.inject.Inject

class FakeFeatureFlagResolver @Inject constructor(): FeatureFlagProvider {

    override fun shouldUseComposeScreen(): Boolean {
        return false
    }
}
