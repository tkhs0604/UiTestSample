package com.tkhs0604.uitestsample.featureflag

import javax.inject.Inject

class FakeFeatureFlagResolver @Inject constructor() : FeatureFlagProvider {
    override fun shouldUseComposeScreen(): Boolean = false
}
