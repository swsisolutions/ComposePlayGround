package com.swasi.uikit.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ComposeRadioButton(
    name: String,
    selected: Boolean,
    onClick: () -> Unit,
    isTextAtEnd: Boolean = false,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors()
) {
    if (!isTextAtEnd) {
        Text(text = name)
    }
    Row {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            colors = colors
        )
    }
    if (isTextAtEnd) {
        Text(text = name)
    }
}