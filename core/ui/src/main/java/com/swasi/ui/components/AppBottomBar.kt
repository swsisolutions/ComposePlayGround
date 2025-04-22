package com.swasi.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBottomBar(
    title: String,
    navIcon: ImageVector,
    contentDesc: String,
    onNavIconClicked: () -> Unit
) {
    BottomAppBar(
        content = {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onNavIconClicked() }) {
                    Icon(navIcon, contentDescription = contentDesc)
                }
                Spacer(modifier = Modifier.width(16.dp))
                AppText(text = title)
            }
        },
        containerColor = Color.Blue
    )
}