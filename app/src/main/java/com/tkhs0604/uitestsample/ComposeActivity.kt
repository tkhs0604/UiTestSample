package com.tkhs0604.uitestsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tkhs0604.uitestsample.ui.theme.UiTestSampleTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiTestSampleTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    var counter by rememberSaveable { mutableStateOf(0) }
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(text = "ComposeActivity", modifier = Modifier.align(Alignment.TopStart))
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text("count: $counter")
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = { counter++ }) {
                                Text("count up")
                            }
                        }

                        val context = LocalContext.current
                        Button(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            onClick = {
                                context.startActivity(
                                    Intent(
                                        this@ComposeActivity,
                                        AndroidViewActivity::class.java
                                    )
                                )
                            }) {
                            Text(text = "Go to AndroidViewActivity")
                        }
                    }
                }
            }
        }
    }
}
