package com.tkhs0604.uitestsample.page

interface MigratingPage {
    fun clickCountUpButton(): MigratingPage
    fun assertScreenName(): MigratingPage
    fun assertCounterLabel(expected: Int): MigratingPage

    companion object {
        fun get(isComposeScreen: Boolean): MigratingPage {
            return if (isComposeScreen) ComposePage else AndroidViewPage
        }
    }
}
