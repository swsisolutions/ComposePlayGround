package com.swasi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun AppCardView() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = paddingModifier
    ) {
        Text(
            text = "Simple Card with elevation",
            modifier = paddingModifier
        )
    }
}

@Composable
fun AppCardWithBorder() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color.Blue),
        modifier = paddingModifier
    ) {
        Text(text = "Card with blue border", modifier = paddingModifier)
    }
}

@Preview
@Composable
fun AppCardViewPreview() {
    AppCardView()
}

@Preview
@Composable
fun AppCardWithBorderPreview() {
    AppCardWithBorder()
}