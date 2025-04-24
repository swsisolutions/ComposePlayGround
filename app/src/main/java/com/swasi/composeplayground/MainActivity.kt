package com.swasi.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.swasi.composeplayground.navigation.accountnav.AccountNavHost
import com.swasi.composeplayground.navigation.moviedb.MovieNavHostController
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import com.swasi.sideeffect.launchedeffect.LaunchedEffectScreen
import com.swasi.sideeffect.rememberCoroutineScope.RememberCoroutineScopeExample
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            val state = remember { mutableStateOf("Account Screen") }
            ComposePlaygroundTheme {

                Column {
                    Greeting(SCREENS.ACCOUNT_SCREEN, onClick = {
                        state.value = SCREENS.ACCOUNT_SCREEN
                    })

                    Greeting(SCREENS.MOVIE_API_SCREEN, onClick = {
                        state.value = SCREENS.MOVIE_API_SCREEN
                    })

                    Greeting(SCREENS.LAUNCHED_EFFECT, onClick = {
                        state.value = SCREENS.LAUNCHED_EFFECT
                    })

                    Greeting(SCREENS.REMEMBER_COROUTINE_SCOPE, onClick = {
                        state.value = SCREENS.REMEMBER_COROUTINE_SCOPE
                    })
                }

                when (state.value) {
                    SCREENS.ACCOUNT_SCREEN -> {
                        AccountNavHost()
                    }

                    SCREENS.MOVIE_API_SCREEN -> {
                        MovieNavHostController()
                    }

                    SCREENS.LAUNCHED_EFFECT -> {
                        LaunchedEffectScreen()
                    }

                    SCREENS.REMEMBER_COROUTINE_SCOPE -> {
                        RememberCoroutineScopeExample()
                    }
                    else -> {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClick: () -> Unit) {
    GreetingItem(
        name = name,
        onClick = onClick
    )
}

@Composable
fun GreetingItem(name: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Text(name)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePlaygroundTheme {
//        Greeting("Android")
    }
}

object SCREENS {
    const val ACCOUNT_SCREEN = "Account Navigation"
    const val MOVIE_API_SCREEN = "Movie Db Navigation"
    const val LAUNCHED_EFFECT = "LaunchedEffectScreen"
    const val REMEMBER_COROUTINE_SCOPE = "RememberCoroutineScopeExample"
}