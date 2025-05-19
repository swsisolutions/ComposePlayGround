package com.swasi.sideeffect.statehoisting.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.sideeffect.statehoisting.login.LoginViewModel
import com.swasi.sideeffect.statehoisting.producthome.ProductHomeViewModel
import com.swasi.sideeffect.statehoisting.register.RegisterViewModel
import com.swasi.sideeffect.R
import com.swasi.ui.theme.Colors

@Composable
fun DashboardScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    registerViewModel: RegisterViewModel = hiltViewModel(),
    productViewModel: ProductHomeViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.appbg),
            contentDescription = "BackgroundImage",
            modifier = Modifier
                .fillMaxSize()
        )
    }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .background(Colors.teal700, RoundedCornerShape(10.dp))
            .alpha(0.5f)
        ) {
            Button(
                onClick =
            ) { }
        }
    }
}