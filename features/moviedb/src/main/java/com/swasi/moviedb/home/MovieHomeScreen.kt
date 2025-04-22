package com.swasi.moviedb.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import swasi.android.ui.components.AppButton
import swasi.android.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieHomeScreen(
    viewModel: MovieHomeViewModel = hiltViewModel(),
    onNavigateToMovieScreen: () -> Unit,
    onNavigateToTvShow: () -> Unit,
    onNavigateToFruits: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Home Screen",
                            color = Color.White
                        )
                    }
                })
        },
        content = {

            ComposePlaygroundTheme(darkTheme = false) {
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

                        Spacer(modifier = Modifier.height(50.dp))
                        AppButton(text = "Movie Home Screen", onClick = {
                        })
                        Spacer(modifier = Modifier.height(50.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            AppButton(
                                text = "TvShow", onClick = {
                                    onNavigateToTvShow()
                                },
                                modifier = Modifier
                                    .border(
                                        width = 0.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .height(50.dp)
                                    .weight(1f)
                            )
                            AppButton(text = "Movie List",
                                modifier = Modifier
                                    .border(
                                        width = 0.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .height(50.dp)
                                    .weight(1f),
                                onClick = {
                                    onNavigateToMovieScreen()
                                })
                        }
                        Spacer(modifier = Modifier.height(50.dp))
                        AppButton(text = "Fruit List", onClick = {
                            onNavigateToFruits()
                        })
                    }
                }
            }
        })
}