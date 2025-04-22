package swasi.android.play.youtubeTutor.rowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import swasi.android.play.youtubeTutor.modifiers.Greeting
import swasi.android.ui.theme.ComposePlaygroundTheme

class RowColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "PreviewColumn")
@Composable
fun DefaultPreview() {
    Column(
        Modifier.fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
            ) {
        Text(text = "Siba")
        Text(text = "Prasad")
        Text(text = "Prasad")
    }
}

@Preview(showBackground = true, name = "PreviewRow")
@Composable
fun DefaultPreviewRow() {
    Row(
        Modifier.fillMaxSize()
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "Siba")
        Text(text = "Prasad")
        Text(text = "Prasad")
    }
}