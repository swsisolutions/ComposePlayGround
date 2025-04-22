package com.swasi.sideeffect.rememberUpdatedState

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleCalculator() {
//    val radius by rememberUpdatedState(newValue = 0f)
//    val color by rememberUpdatedState(newValue = Color.Red)

    var radius by remember { mutableFloatStateOf(0.0f) }
    var color by remember { mutableStateOf(Color.Red) }

    val area = remember(radius) { calculateArea(radius) }
    val circumference = remember(radius) { calculateCircumference(radius) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        TextField(
            value = radius.toString(),
            onValueChange = { radius = it.toFloatOrNull() ?: 0f },
            label = { Text("Enter radius") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ColorPicker(
            colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow),
            selectedColor = color,
            onColorSelected = { color = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Area: $area units²")
        Text("Circumference: $circumference units")
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .background(color, CircleShape)
                .fillMaxSize()
                .aspectRatio(1f)
        )
    }
}

fun calculateArea(radius: Float): Float {
    return (Math.PI * radius * radius).toFloat()
}

fun calculateCircumference(radius: Float): Float {
    return (2 * Math.PI * radius).toFloat()
}

@Composable
fun ColorPicker(
    colors: List<Color>,
    selectedColor: Color,
    onColorSelected: (Color) -> Unit
) {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .background(color, CircleShape)
                    .padding(16.dp)
                    .size(50.dp)
                    .clickable(onClick = { onColorSelected(color) })
                    .border(
                        width = 2.dp,
                        color = if (color == selectedColor) Color.Black else Color.Transparent,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview
@Composable
fun RememberUpdateStatePreview() {
    CircleCalculator()
}