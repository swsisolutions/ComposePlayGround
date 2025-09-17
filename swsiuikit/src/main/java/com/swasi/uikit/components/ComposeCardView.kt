package com.swasi.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.uikit.R

@Composable
fun ComposeCardView(
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    contentColor: Color = Color.White,
    radios: Int = 8,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(radios.dp),
        content = content,
        elevation = elevation,
        colors = CardDefaults.cardColors(
            contentColor
        )
    )
}

@Composable
fun CardTextWithIcon(country: Country, onRemoveClicked: (country: Country) -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = country.name, fontWeight = FontWeight.Bold)
            IconButton(
                modifier = Modifier
                    .size(50.dp),
                onClick = {
                    onRemoveClicked(country)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(id = R.string.close_desc)
                )
            }
        }
    }
}


@Composable
fun ComposeCardView() {
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
    ComposeCardView()
}

@Preview
@Composable
fun AppCardWithBorderPreview() {
    AppCardWithBorder()
}

@Preview
@Composable
fun ComposeCardViewPreview() {
    ComposeCardView(
        content = { Text(text = "sdkfjhskjdfhksdf") }
    )
}
