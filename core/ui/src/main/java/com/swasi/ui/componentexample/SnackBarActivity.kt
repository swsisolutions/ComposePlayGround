package com.swasi.ui.componentexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarSample()
        }
    }

    @Composable
    fun SnackbarSample(){
//        val scaffoldState = rememberScaffoldState()
//        val scope = rememberCoroutineScope()
//        Scaffold(
//            scaffoldState = scaffoldState,
//            floatingActionButton = {
//                var clickCount by remember { mutableStateOf(0) }
//                ExtendedFloatingActionButton(
//                    text = { Text("Show snackbar") },
//                    onClick = {
//                        // show snackbar as a suspend function
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
//                        }
//                    }
//                )
//            },
//            content = { innerPadding ->
//                Text(
//                    text = "Body content",
//                    modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
//                )
//            }
//        )
    }
}