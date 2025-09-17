package com.swasi.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.swasi.uikit.R


/**
 * https://www.jetpackcompose.net/image-in-jetpack-compose
 */

@Composable
fun ComposeImageView(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {

}

@Composable
fun ComoseSimpleImage() {
    ComposeImageView(
        painter = painterResource(id = R.drawable.ic_rabit),
        contentDescription = "Andy Rubin",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CircleImageView() {
    ComposeImageView(
        painter = painterResource(R.drawable.ic_rabit),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape) // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)//optional
    )
}

@Composable
fun RoundCornerImageView() {
    ComposeImageView(
        painter = painterResource(R.drawable.ic_rabit),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))
            .border(5.dp, Color.Gray, RoundedCornerShape(10))
    )
}

@Composable
fun ImageWithBackgroundColor() {
    ComposeImageView(
        painter = painterResource(id = R.drawable.ic_rabit),
        contentDescription = "",
        modifier = Modifier
            .size(200.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}

@Composable
fun ImageWithTint() {
    ComposeImageView(
        painter = painterResource(id = R.drawable.ic_rabit),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size(200.dp)
    )
}


@Composable
fun AppImageView(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier.composed {
            modifier
        },
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}

@Composable
fun AppCircleImageView(
    painter: Painter,
    contentDescription: String?,
    size: Dp = 100.dp,
    modifier: Modifier = Modifier
        .size(size)
        .clip(CircleShape) // clip to the circle shape
        .border(5.dp, Color.Gray, CircleShape),
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier.composed { modifier }
    )
}

@Composable
fun AppRoundCornerImageView(
    painter: Painter,
    contentDescription: String?,
    size: Dp = 100.dp,
    modifier: Modifier = Modifier
        .size(size)
        .clip(RoundedCornerShape(10))
        .border(5.dp, Color.Gray, RoundedCornerShape(10)),
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment
    )
}


