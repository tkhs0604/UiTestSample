package com.tkhs0604.uitestsample.page

interface TransitionTargetPage {
    fun clickCountUpButton(): TransitionTargetPage
    fun assertScreenName(): TransitionTargetPage
    fun assertCounterLabel(expected: Int): TransitionTargetPage

    companion object {
        fun get(isComposeScreen: Boolean): TransitionTargetPage {
            return if (isComposeScreen) ComposePage else AndroidViewPage
        }
    }
}
