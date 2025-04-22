package swasi.android.play.youtubeTutor.stateManagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import swasi.android.ui.components.AppButton
import kotlin.random.Random

class StateManagementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StateCompose()
        }
    }
}

@Composable
fun StateCompose() {
    var visible by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize()) {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        ColorBox(
            Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value = it
        }
        Box(
            modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize()
        ) {

        }
    }
}


@Preview
@Composable
fun StateComposePreview() {
    StateCompose()
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {

    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}

@Preview
@Composable
fun CheckColorChange() {
    Column(Modifier.fillMaxSize()) {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        var isButtonVisible by remember { mutableStateOf(true) }
        Row(horizontalArrangement = Arrangement.End) {
            if (isButtonVisible) {
                AppButton(
                    onClick = {
                        isButtonVisible = !isButtonVisible
                    },
                    modifier = Modifier
                )
            }

            AppButton(
                text = "Show Or Hide",
                onClick = {
                    isButtonVisible = !isButtonVisible
                },
                modifier = Modifier
            )
        }

        ColorBox(
            Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value = it
        }
        Box(
            modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize()
        ) {

        }
    }
}

@Composable
fun ColorBoxClickStateChange(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }
    ) {

    }
}