package com.tkhs0604.uitestsample.page

interface SamplePage {
    fun clickButton(): SamplePage

    companion object {
        var isComposeScreen = false
        fun get(): SamplePage = if (isComposeScreen) {
            ComposeSamplePage
        } else {
            AndroidViewSamplePage
        }
    }
}
