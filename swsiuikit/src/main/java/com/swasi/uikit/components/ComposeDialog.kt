package com.swasi.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun ComposeConfirmDialog(
    title: String,
    message: String,
    confirmButtonText: String,
    onConfirmClicked: () -> Unit,
    onDismiss: () -> Unit
) {
    var showPopUp by remember { mutableStateOf(true) }
    val onPopupDismissed = { showPopUp = false }

    if (showPopUp) {
        AlertDialog(
            onDismissRequest = {
                onPopupDismissed()
                onDismiss()
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                Button(
                    onClick = onConfirmClicked,
                ) {
                    Text(text = confirmButtonText)
                }
            }
        )
    }
}

fun <T> ((T) -> Boolean).and(arg: (T) -> Boolean): (T) -> Boolean = { this(it) && arg(it) }

@Composable
fun DeleteDialog(
    title: String,
    message: String,
    deleteButtonText: String,
    onConfirmClicked: (close: Boolean) -> Unit
) {
    var showPopUp by remember { mutableStateOf(true) }
    val onPopupDismissed = {
        showPopUp = false
    }

    if (showPopUp) {
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            title = {
                Text(text = title)
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                Button(
                    onClick = {
                        showPopUp = false
                        onConfirmClicked(true)
                    },
                ) {
                    Text(text = deleteButtonText)
                }
            }
        )
    }
}

// The choices are the display name of each item.
// The output is the index the user chose.
@Composable
fun ChoiceDialog(
    currentChoice: Int,
    choices: List<String>,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onChoose: (Int) -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        RadioButtons(
            choices,
            choices[currentChoice],
            Modifier
                .fillMaxWidth()
                .then(modifier)
        ) { onChoose(it); onDismiss() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeFullScreenDialog(
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false // This is the key
        )
    ) {
        // We use a Scaffold to get a typical screen layout with a TopAppBar.
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Full-Screen Dialog") },
                    navigationIcon = {
                        IconButton(onClick = { onDismissRequest() }) {
                            Icon(Icons.Filled.Close, contentDescription = "Close")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content
            }
        }
    }
}