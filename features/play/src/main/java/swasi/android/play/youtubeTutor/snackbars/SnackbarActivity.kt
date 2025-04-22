package swasi.android.play.youtubeTutor.snackbars

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class SnackbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
             Snackbar() {
                 Text(text = "Hello Sibaprasad")
             }
         }

        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            var textFieldState by remember {
                mutableStateOf("")
            }

            Scaffold(
                Modifier.fillMaxSize()
            ) { padding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(value = textFieldState, label = {
                        Text(text = "Enter your name")
                    }, onValueChange = {
                        textFieldState = it
                    },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "Hello # $textFieldState"
                            )
                        }
                    }) {
                        Text(text = "Please Greet Me")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Snackbar example")
@Composable
fun showSnackBarPreview() {
    Snackbar() {
        Text(text = "Hello Sibaprasad")
    }
}
