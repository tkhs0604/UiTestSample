package com.tkhs0604.uitestsample

import javax.inject.Inject

class FakeFeatureFlagResolver @Inject constructor(): FeatureFlagProvider {

    override fun shouldUseComposeScreen(): Boolean {
        return false
    }
}
