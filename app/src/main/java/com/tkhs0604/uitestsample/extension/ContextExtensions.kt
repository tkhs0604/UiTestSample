package com.tkhs0604.uitestsample.extension

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity

inline fun <reified T : ComponentActivity> Context.launchActivity() {
    startActivity(createIntent<T>())
}

inline fun <reified T : ComponentActivity> Context.createIntent(): Intent {
    return Intent(this, T::class.java)
}
