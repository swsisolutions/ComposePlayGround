package com.swasi.moviedb.tvshow

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.swasi.domain.moviedb.ItemResult
import com.swasi.moviedb.R
import com.swasi.ui.components.ProgressIndicator
import swasi.android.network.RestConfig

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowScreen(viewModel: TvShowViewModel = hiltViewModel()) {
    LaunchedEffect(Unit, block = {
        viewModel.getPopularTvShowList()
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
        content = {
            when (val state = viewModel.tvShowState.collectAsState().value) {
                TvShowViewModel.State.Error -> {
                    Text("Error", Modifier.fillMaxSize())
                }

                TvShowViewModel.State.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ProgressIndicator()
                    }
                }

                is TvShowViewModel.State.Data -> {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .background(Color.Gray)
                            .padding(2.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxHeight().background(
                                colorResource(com.swasi.ui.R.color.teal_200)
                            ),
                            verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            items(state.data) { fruit ->
                                TvShowItemRow(fruit)
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun TvShowList(fruitList: MutableList<ItemResult>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(fruitList) { model ->
            TvShowItemRow(model = model)
        }
    }
}

@Composable
fun TvShowItemRow(model: ItemResult) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        val imageUrl = RestConfig.BASE_IMAGE_URL + model.posterPath
        Log.i("Image Url", imageUrl)
        GlideImage(
            imageModel = imageUrl,
            contentDescription = model.name,
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(5000),
            error = ImageBitmap.imageResource(R.drawable.error),
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name!!,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}


