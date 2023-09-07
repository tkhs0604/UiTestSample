package com.tkhs0604.uitestsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.tkhs0604.uitestsample.extension.launchActivity
import com.tkhs0604.uitestsample.ui.theme.UiTestSampleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var featureFlagProvider: FeatureFlagProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiTestSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box {
                        val context = LocalContext.current
                        Button(
                            modifier = Modifier.align(Alignment.Center),
                            onClick = {
                            if (featureFlagProvider.shouldUseComposeScreen()) {
                                context.launchActivity<ComposeActivity>()
                            } else {
                                context.launchActivity<AndroidViewActivity>()
                            }
                        }
                        ) {
                            Text("Go to next activity")
                        }
                    }
                }
            }
        }
    }
}
