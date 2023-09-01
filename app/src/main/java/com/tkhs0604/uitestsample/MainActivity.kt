package com.tkhs0604.uitestsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tkhs0604.uitestsample.ui.theme.UiTestSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiTestSampleTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                NavHost(
                    navController = navController,
                    startDestination = "main",
                ) {
                    composable("main") {
                        MainScreen(
                            onClickGoToComposeActivity = {
                                context.launchActivity<ComposeActivity>()
                            },
                            onClickGoToAndroidViewActivity = {
                                context.launchActivity<AndroidViewActivity>()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onClickGoToComposeActivity: () -> Unit,
    onClickGoToAndroidViewActivity: () -> Unit,
) {
    Column {
        Button(onClick = onClickGoToComposeActivity) {
            Text(text = "Go to ComposeActivity")
        }
        Button(onClick = onClickGoToAndroidViewActivity) {
            Text(text = "Go to AndroidViewActivity")
        }
    }
}

private inline fun <reified T : ComponentActivity> Context.launchActivity() {
    startActivity(createIntent<T>())
}

private inline fun <reified T : ComponentActivity> Context.createIntent(): Intent {
    return Intent(this, T::class.java)
}

