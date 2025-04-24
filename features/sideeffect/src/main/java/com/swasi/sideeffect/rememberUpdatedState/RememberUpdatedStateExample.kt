package com.swasi.sideeffect.rememberUpdatedState

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Timer(
    buttonColour: String
) {
    val timerDuration = 5000L
    println("Composing timer with colour : $buttonColour")
    LaunchedEffect(key1 = Unit, block = {
        startTimer(timerDuration) {
            println("Timer ended")
            println("Last pressed button color was $buttonColour")
        }
    })
}

@Composable
fun TimerWithRememberUpdatedState(
    buttonColour: String
) {
    val timerDuration = 5000L
    println("Composing timer with colour : $buttonColour")
    val buttonColorUpdated by rememberUpdatedState(newValue = buttonColour)
    LaunchedEffect(key1 = Unit, block = {
        startTimer(timerDuration) {
            println("Timer ended")
            println("[1] Last pressed button color is $buttonColour")
            println("[2] Last pressed button color is $buttonColorUpdated")
        }
    })
}

suspend fun startTimer(time: Long, onTimerEnd: () -> Unit) {
    delay(timeMillis = time)
    onTimerEnd()
}

@Composable
fun TwoButtonScreen() {
    var buttonColour by remember {
        mutableStateOf("Unknown")
    }
    var rememberCoroutineScope by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = {
                buttonColour = "Red"
            },
            colors = ButtonDefaults.buttonColors(
                Color.Red
            )
        ) {
            Text("Red Button")
        }
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                buttonColour = "Black"
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black
            )
        ) {
            Text("Black Button")
        }
        Checkbox(checked = rememberCoroutineScope, onCheckedChange = {
            rememberCoroutineScope = !rememberCoroutineScope
        })
        Text(
            fontSize = 16.sp,
            text = "use Remember UpdateState"
        )
        if (rememberCoroutineScope) {
            TimerWithRememberUpdatedState(buttonColour = buttonColour)
        } else {
            Timer(buttonColour = buttonColour)
        }
    }
}

@Preview
@Composable
fun RememberUpdatedStatePreview() {
    TwoButtonScreen()
}



