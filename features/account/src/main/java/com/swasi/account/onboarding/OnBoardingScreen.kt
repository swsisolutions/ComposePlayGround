package com.swasi.account.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.account.R
import com.swasi.ui.components.AppButton
import com.swasi.ui.components.AppImageView
import com.swasi.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppImageView(
                    painter = painterResource(id = R.drawable.jet_pack_compose),
                    contentDescription = "Apple",
                    modifier = Modifier.fillMaxSize(0.5f)
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    AppButton(
                        text = "SignIn", onClick = {
                            onNavigateToSignIn()
                        },
                        modifier = Modifier
                            .height(50.dp)
                    )
                    Spacer(modifier = Modifier.width(50.dp))
                    AppButton(
                        text = "SignUp", onClick = {
                            onNavigateToSignUp()
                        },
                        modifier = Modifier
                            .height(50.dp)
                    )
                }
            }
        }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(OnBoardingViewModel(), {}, {})
}