package com.swasi.uikit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier.then(Modifier.verticalScroll(rememberScrollState())),
        verticalArrangement,
        horizontalAlignment,
        content
    )
}

@Composable
fun ExpandableContent(
    // The function passed inside this composable is for expanding/collapsing
    container: @Composable () -> Unit,
    expandState: MutableState<Boolean> = remember { mutableStateOf(false) },
    indent: Dp = 32.dp,
    needArrow: Boolean = true,
    needFillWidth: Boolean = true,
    content: @Composable () -> Unit
) {
    Column(
        modifier = if (needFillWidth) Modifier.fillMaxWidth() else Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expandState.value = !expandState.value },
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (needArrow) {
                Icon(
                    painterResource(
                        if (expandState.value) android.R.drawable.arrow_down_float
                        else android.R.drawable.arrow_down_float
                    ), "", Modifier.padding(start = 16.dp)
                )
            }
            container()
        }
        if (expandState.value) {
            Row(Modifier.fillMaxWidth()) {
                Spacer(Modifier.width(indent))
                Column(Modifier.weight(1f)) { content() }
            }
        }
    }
}