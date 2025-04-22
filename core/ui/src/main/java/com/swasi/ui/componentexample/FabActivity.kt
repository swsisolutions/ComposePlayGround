package com.swasi.ui.componentexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class FabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloatingActionButtonSample()
        }
    }
}

@Composable
fun FloatingActionButtonSample() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "FAB clicked", Toast.LENGTH_SHORT).show()
    }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
    }
}

@Preview
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButtonSample()
}