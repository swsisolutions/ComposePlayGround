package com.swasi.uikit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeBottomSheet(
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

    when {
        sheetState.isVisible -> {
            ModalBottomSheet(
                modifier = Modifier.fillMaxSize(),
                onDismissRequest = onDismiss,
                sheetState = sheetState
            ) {
                Text(text = "Bottom Sheet Content")
            }
        }
    }
}


@Composable
fun ComposeBottomSheetContent(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Bottom Sheet Content")
        Button(onClick = onDismiss) {
            Text(text = "Close")
        }
    }
}

@Composable
fun MyScreenContent(onOpenBottomSheet: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Main Content")
        Button(onClick = onOpenBottomSheet) {
            Text(text = "Open Bottom Sheet")
        }
    }
}


/*
@Composable
fun BottomSheet() {
    val context = LocalContext.current
    val bottomSheetState = remember {
        ModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            density = Density(context))
    }

    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            MyBottomSheetContent(onDismiss = {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }
            })
        },
        content = {
            MyScreenContent(onOpenBottomSheet = {
                coroutineScope.launch {
                    bottomSheetState.show()
                }
            })
        }
    )
}*/
