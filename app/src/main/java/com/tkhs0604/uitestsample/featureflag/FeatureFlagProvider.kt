package com.tkhs0604.uitestsample.featureflag

import javax.inject.Inject

interface FeatureFlagProvider {
    fun shouldUseComposeScreen(): Boolean
}

class FeatureFlagProviderImpl @Inject constructor(): FeatureFlagProvider {
    override fun shouldUseComposeScreen(): Boolean = true
}
