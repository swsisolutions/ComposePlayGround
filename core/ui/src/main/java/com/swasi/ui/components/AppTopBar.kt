package com.swasi.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.swasi.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    navIcon: ImageVector,
    contentDesc: String,
    onNavIconClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onNavIconClicked() }) {
                Icon(navIcon, contentDescription = contentDesc)
            }

        },
        colors = TopAppBarColors(
            containerColor = Colors.teal200,
            Colors.teal200, Colors.teal200, Colors.teal200, Colors.purple700
        )
    )
}