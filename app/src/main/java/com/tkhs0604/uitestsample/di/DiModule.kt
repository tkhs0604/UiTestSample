package com.tkhs0604.uitestsample.di

import com.tkhs0604.uitestsample.featureflag.FeatureFlagProvider
import com.tkhs0604.uitestsample.featureflag.FeatureFlagProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Singleton
    @Binds
    abstract fun bindFeatureFlagProvider(
        impl: FeatureFlagProviderImpl,
    ): FeatureFlagProvider
}
