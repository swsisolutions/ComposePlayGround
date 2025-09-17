package com.swasi.uikit.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

object Styles {

    fun getTextStyle(
        textColor: Color = Color.Black,
        textSize: TextUnit = 15.sp,
        fontWeight: FontWeight = FontWeight.Medium
    ) = TextStyle(
        color = textColor,
        fontSize = textSize,
        fontWeight = fontWeight,
        fontStyle = FontStyle.Normal,
        letterSpacing = 0.5.em,
        background = Color.Transparent,
        textDecoration = TextDecoration.None
    )

}