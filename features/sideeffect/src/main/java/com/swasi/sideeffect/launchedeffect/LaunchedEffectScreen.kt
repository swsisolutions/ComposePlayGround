package com.swasi.sideeffect.launchedeffect

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.ui.R
import com.swasi.ui.common.Resource
import com.swasi.ui.components.Image
import com.swasi.ui.components.ProgressIndicator
import kotlinx.parcelize.Parcelize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchedEffectScreen(
    viewModel: LaunchedEffectViewModel = LaunchedEffectViewModel()
) {

    LaunchedEffect(Unit, {
        viewModel.getStaticDataList()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Popular Tv Show",
                            color = Color.White
                        )
                    }
                })
        },
        content = { padding ->
            when (val state = viewModel.dataListFlow.collectAsState().value) {
                is Resource.Error -> Text(state.message ?: "Error")
                is Resource.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(padding)
                            .background(
                                colorResource(R.color.teal_200)
                            ),
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        items(state.data.list) { launchedData ->
                            LaunchedScreenItem(launchedData)
                        }
                    }
                }

                Resource.Loading -> ProgressIndicator()
//                Resource.Idle -> {}
            }
        }
    )
}

@Composable
fun LaunchedScreenItem(data: LaunchedData) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(R.drawable.actor1),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(0.2f)
        )
        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = AbsoluteAlignment.Left
        ) {
            Text(
                text = data.name,
                modifier = Modifier.fillMaxWidth(0.5f),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 18.sp
            )
            Text(
                text = data.description,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
        }
    }
}

@Keep
@Parcelize
data class LaunchedData(val name: String, val description: String) : Parcelable

@Keep
@Parcelize
data class LaunchedDataList(val list: List<LaunchedData>) : Parcelable