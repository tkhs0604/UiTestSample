package com.tkhs0604.uitestsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun ComposeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        var counter by rememberSaveable { mutableIntStateOf(0) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("ComposeActivity", modifier = Modifier.align(Alignment.TopStart))
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("count: $counter", modifier = Modifier.testTag(ComposeScreenTestTags.COUNTER_LABEL))
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { counter++ },
                    modifier = Modifier.testTag(ComposeScreenTestTags.COUNT_UP_BUTTON)
                ) {
                    Text("count up")
                }
            }
        }
    }
}

object ComposeScreenTestTags {
    const val COUNTER_LABEL = "counter_label"
    const val COUNT_UP_BUTTON = "count_up_button"
}
