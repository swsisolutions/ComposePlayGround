package com.swasi.moviedb.fruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import com.swasi.moviedb.R
import com.swasi.moviedb.theme.MovieComposeTheme
import com.swasi.ui.components.AppButton
import com.swasi.ui.components.AppText

/**
 * Created by Sibaprasad Mohanty on 20/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitDetailsScreen(
    fruitDataInJson: String?,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {

    val fruitData = Gson().fromJson(fruitDataInJson, FruitData::class.java) ?: FruitData(
        0,
        "BANANA",
        R.drawable.apple
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Fruit Details",
                            color = Color.White
                        )
                    }
                })
        },
        content = {

            MovieComposeTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppButton(
                            text = "Back",
                            onClick = popBackStack
                        )

                        AppButton(
                            text = "Log Out",
                            onClick = popUpToLogin
                        )

                        Image(
                            painter = painterResource(fruitData.image),
                            contentDescription = fruitData.fruitName,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize(0.5F)
                        )
                        AppText(
                            text = fruitData.fruitName,
                            size = 20.sp,
                            textColor = Color.Blue
                        )
                    }
                }
            }
        })
}