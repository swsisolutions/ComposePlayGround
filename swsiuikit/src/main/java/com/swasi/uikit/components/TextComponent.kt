package com.swasi.uikit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.uikit.theme.Styles

@Composable
fun AppTitleTextView(
    text: String,
    style: TextStyle? = Styles.getTextStyle(),
    modifier: Modifier = Modifier.padding(0.dp),
    isClickable: Boolean = false,
    onClickListener: (() -> Unit)? = null
) {
    Text(
        text = text,
        style = style ?: TextStyle.Default,
        modifier = Modifier
            .composed { modifier }
            .clickable(enabled = isClickable) {
                onClickListener?.let {
                    onClickListener()
                }
            }
    )
}

@Composable
fun AppBodyTextView(
    text: String,
    style: TextStyle? = Styles.getTextStyle(textSize = 14.sp),
    modifier: Modifier = Modifier.padding(0.dp),
    isClickable: Boolean = false,
    onClickListener: (() -> Unit)? = null
) {
    Text(
        text = text,
        style = style ?: TextStyle.Default,
        modifier = Modifier
            .composed { modifier }
            .clickable(enabled = isClickable) {
                onClickListener?.let {
                    onClickListener()
                }
            }
    )
}

@Composable
fun AppText(
    text: String,
    textColor: Color = Color.Black,
    size: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Light,
    maxLines: Int = 1,
//    fontFamily: FontFamily = AppFonts
) {
    Text(
        text = text,
        color = textColor,
        fontSize = size,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}

@Composable
fun AppTextTitle(
    text: String,
    textColor: Color = Color.Black,
    size: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(text = text, color = textColor, fontSize = size, fontWeight = fontWeight)
}

@Composable
fun OverflowedText() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}

@Preview
@Composable
fun AppTitleTextViewPreview() {
    AppTitleTextView("Hello")
}

@Preview
@Composable
fun AppBodyTextViewPreview() {
    AppBodyTextView("Hello")
}

@Preview(name = "Text1")
@Composable
fun appTextPreview() {
    AppText("Sibaprasad")
}


