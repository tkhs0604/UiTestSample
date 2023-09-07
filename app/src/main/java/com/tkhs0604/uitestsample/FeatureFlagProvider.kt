package com.tkhs0604.uitestsample

import javax.inject.Inject

interface FeatureFlagProvider {
    fun shouldUseComposeScreen(): Boolean
}

class FeatureFlagProviderImpl @Inject constructor(): FeatureFlagProvider {
    override fun shouldUseComposeScreen(): Boolean = true
}
