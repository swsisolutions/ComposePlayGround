package com.swasi.sideeffect.launchedeffect

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun TimerScreen1() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var timerDuration by remember {
            mutableStateOf(1000L) // default value = 1 sec
        }
        Button({
            timerDuration -= 1000
        }) {
            Text("-1 second")
        }
        Text(timerDuration.toString())
        Button({
            timerDuration += 1000
        }) {
            Text("+1 second")
        }
        Timer(timerDuration = timerDuration)
    }
}

@Composable
fun Timer(timerDuration: Long) {
    val context = LocalContext.current
    LaunchedEffect(key1 = timerDuration, block = {
        try {
            startTimer(timerDuration) {
                Toast.makeText(context, "Timer Ended", Toast.LENGTH_SHORT).show()
            }
        } catch (ex: Exception) {
            println("timer cancelled")
            Toast.makeText(context, "Timer Cancelled", Toast.LENGTH_SHORT).show()
        }
    })
}

suspend fun startTimer(time: Long, onTimerEnd: () -> Unit) {
    delay(timeMillis = time)
    onTimerEnd()
}

@Preview
@Composable
fun LaunchedEffectExample1() {
    TimerScreen1()
}

/**
 * // Create the timer flow
 * val timer = (0..Int.MAX_VALUE)
 *     .asSequence()
 *     .asFlow()
 *     .onEach { delay(1_000) } // specify delay
 *
 * // Consume it
 * timer.collect {
 *     println("bling: ${it}")
 * }
 *
 *
 */