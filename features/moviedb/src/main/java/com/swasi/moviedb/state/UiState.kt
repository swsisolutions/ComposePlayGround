package com.swasi.moviedb.state


/**
 * Created by Sibaprasad Mohanty on 20/03/2023.
 * siba.x.prasad@gmail.com
 */

sealed class UiState<out T : Any> {
    object Loading : UiState<Nothing>()
    data class Error(val message: String, val cause: Exception? = null) : UiState<Nothing>()
    data class Data<out T : Any>(val value: List<T>) : UiState<T>()
}