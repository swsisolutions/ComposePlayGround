package com.swasi.ui.componentexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainWidgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExample()
        }
    }
}

@Composable
fun BoxExample() {
    val context = LocalContext.current
    Box(Modifier.fillMaxSize()) {
        Text("This is first text", modifier = Modifier.align(Alignment.TopCenter))
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight()
                .width(
                    1.dp
                )
                .background(Color.Blue)
        )

        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(
                    1.dp
                )
                .background(Color.Blue)
        )

        Text("This is second text", modifier = Modifier.align(Alignment.Center))
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            onClick = {
                Toast.makeText(context, "Bottom End clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("+")
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp),
            onClick = {
                Toast.makeText(context, "TOP End clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("+")
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp),
            onClick = {
                Toast.makeText(context, "Top Start clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("+")
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp),
            onClick = {
                Toast.makeText(context, "Bottom Start clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("+")
        }
    }
}

@Preview
@Composable
fun BoxPreview() {
    BoxExample()
}