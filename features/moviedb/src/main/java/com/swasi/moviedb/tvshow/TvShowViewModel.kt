package com.swasi.moviedb.tvshow

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import swasi.android.model.ItemResult
import swasi.android.network.MovieDbApiService
import javax.inject.Inject

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class TvShowViewModel @Inject constructor(private val apiService: MovieDbApiService) : ViewModel() {
    var isLoading = mutableStateOf(false)
    var movieListResponse: List<ItemResult> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    sealed class State {
        object Loading : State()
        object Error : State()
        data class Data(val data: List<ItemResult>) : State()
    }

    private var _tvSHowState = MutableStateFlow<State>(State.Loading)
    val tvShowState = _tvSHowState.asStateFlow()

    fun getPopularTvShowList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val movieList = apiService.getPopularTvShowsByFlow(page = 1)
                movieListResponse = movieList.results
                _tvSHowState.value = State.Data(movieList.results)
                isLoading.value = false
                Log.i("Compose", "Tv SHow Response $movieListResponse")
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                isLoading.value = false
            }
        }
    }
}