package swasi.android.play.youtubeTutor.btntxtfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ButtonTextSnackBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Snackbar() {
                Text(text = "Hello Sibaprasad")
            }
        }
    }
}

@Preview(showBackground = true, name = "PreviewColumn")
@Composable
fun DefaultPreview() {
    Snackbar() {
        Text(text = "Hello Sibaprasad")
    }
}
