package swasi.android.play.youtubeTutor.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var sizeState by remember {
                mutableStateOf(200.dp)
            }

            val size by animateDpAsState(
                targetValue = sizeState,
//                spring(Spring.DampingRatioHighBouncy)
                tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                ), label = ""
//            keyframes {
//                durationMillis = 5000
//                sizeState at 0 with LinearEasing
//                sizeState * 1.5 at 1000 with FastOutLinearInEasing
//            }
            )

            Box(
                modifier = Modifier
                    .size(size)
                    .background(Color.Red)
            ) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text(text = "Increase Size")
                }
            }
        }
    }
}