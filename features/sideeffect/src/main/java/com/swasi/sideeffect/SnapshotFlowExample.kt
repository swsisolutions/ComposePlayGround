package com.swasi.sideeffect

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map


/**
 * snapshotFlow: convert Compose's State into Flows
 */

@Composable
fun SnapshotFlowExample() {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        // ...
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index -> index > 0 }
            .distinctUntilChanged()
            .filter { it == true }
            .collect {
//                MyAnalyticsService.sendScrolledPastFirstItemEvent()
            }
    }
}

