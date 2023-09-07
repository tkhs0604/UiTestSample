package com.tkhs0604.uitestsample.di

import com.tkhs0604.uitestsample.FakeFeatureFlagResolver
import com.tkhs0604.uitestsample.FeatureFlagProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DiModule::class]
)
abstract class FakeDiModule {

    @Singleton
    @Binds
    abstract fun bindFeatureFlagResolver(
        impl: FakeFeatureFlagResolver,
    ): FeatureFlagProvider
}

