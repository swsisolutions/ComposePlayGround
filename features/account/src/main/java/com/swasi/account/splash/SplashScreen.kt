package com.swasi.account.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.account.R
import com.swasi.ui.theme.ComponentTheme
import com.swasi.ui.components.AppButton
import com.swasi.ui.components.AppImageView
import com.swasi.ui.components.ProgressIndicator

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToOnBoarding: () -> Unit
) {
    DisposableEffect(Unit) {
        Log.i("SplashScreen", "Splash Screen Composed")
        onDispose { Log.i("SplashScreen", "Splash Screen  DISPOSED") }
    }
    ComponentTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(10.dp)
            ) {
                AppImageView(
                    painter = painterResource(id = R.drawable.jet_pack_compose),
                    contentDescription = "splashImage",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .align(Alignment.Center)
                )
                ProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.BottomCenter
                    )
                )

//                if (viewModel.isLoaded.value) {
//                    onNavigateToOnBoarding()
//                }

                AppButton(
                    text = "Skip", onClick = {
                        onNavigateToOnBoarding()
                    },
                    modifier = Modifier
                        .height(50.dp)
                        .align(Alignment.TopEnd)
                )

            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        SplashViewModel(),
        onNavigateToOnBoarding = {}
    )
}