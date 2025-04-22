package com.swasi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.swasi.ui.R


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

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

@Preview
@Composable
fun AppImageViewPreview() {
    val paintResource = painterResource(id = R.drawable.ic_rabit)
    AppImageView(painter = paintResource, "")
}


@Preview
@Composable
fun AppCircleImageViewPreview() {
    val paintResource = painterResource(id = R.drawable.ic_rabit)
    AppCircleImageView(painter = paintResource, "")
}

@Preview
@Composable
fun AppRoundCornerImageViewPreview() {
    val paintResource = painterResource(id = R.drawable.ic_rabit)
    AppRoundCornerImageView(painter = paintResource, "")
}