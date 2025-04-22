package com.swasi.account.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.account.R
import com.swasi.ui.components.AppImageView
import com.swasi.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun AccountHomeScreen(
    viewModel: AccountHomeViewModel = hiltViewModel(),
    productId: String
) {
    ComposePlaygroundTheme(darkTheme = false) {
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
                    Text(
                       "Welcome to Account Home screen: $productId"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    AccountHomeScreen(AccountHomeViewModel(), "")
}