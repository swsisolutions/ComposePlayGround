package com.swasi.ui.componentexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

class SliderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderExample()
        }
    }
}

@Composable
fun SliderExample() {
    var slider by remember { mutableFloatStateOf(0f) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Text(text = slider.toString())
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}

@Preview
@Composable
fun SliderPreview() {
    SliderExample()
}