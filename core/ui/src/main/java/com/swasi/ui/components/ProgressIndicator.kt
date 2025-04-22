package com.swasi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

const val PROGRESS_INDETERMINATE = 0
const val PROGRESS_LINEAR_INDICATOR = 1
const val PROGRESS_CIRCULAR = 2
const val PROGRESS_LINEAR = 3

@Composable
fun ProgressIndicator(
    progressType: Int = 0,
    progressColor: Color = Color.Blue,
    strokeWidth: Dp = 10.dp,
    modifier: Modifier = Modifier.padding(0.dp),
    linearHeight: Dp = 15.dp
) {
    when (progressType) {
        PROGRESS_INDETERMINATE -> {
            CircularProgressIndicator(
                modifier = modifier.composed { modifier },
                color = progressColor,
                strokeWidth = strokeWidth
            )
        }

        PROGRESS_LINEAR_INDICATOR -> {

            Column(modifier = Modifier.fillMaxWidth()) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(linearHeight),
                    color = progressColor
                )
            }
        }
    }
}

@Composable
fun Progress(
    progressType: Int,
    progressValue: Float,
    modifier: Modifier = Modifier.padding(0.dp),
    color: Color = Color.Blue,
    strokeColor: Color = Color.Gray,
    strokeWidth: Dp = 10.dp
) {
    when (progressType) {
        PROGRESS_INDETERMINATE -> {
            CircularProgressIndicator(
                modifier = modifier.composed { modifier },
                color = color,
                strokeWidth = strokeWidth
            )
        }

        PROGRESS_LINEAR_INDICATOR -> {
            LinearProgressIndicator(
                progressValue,
                modifier = Modifier.composed {
                    modifier
                },
                color = color
            )
        }
    }
}

@Preview
@Composable
fun CircularProgressIndicatorPreview() {
    ProgressIndicator(0)
}

@Preview
@Composable
fun LinearProgressIndicatorPreview() {
    ProgressIndicator(1)
}

@Preview
@Composable
fun CircularProgressPreview() {
    Progress(2, progressValue = 0.5f)
}

@Preview
@Composable
fun LinearProgressPreview() {
    Progress(3, progressValue = 0.5f)
}