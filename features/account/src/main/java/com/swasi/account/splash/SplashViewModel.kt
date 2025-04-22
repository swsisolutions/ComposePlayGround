package com.swasi.account.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    val isLoaded = mutableStateOf(false)

    fun load() {
        viewModelScope.launch {
            delay(5000L)
            isLoaded.value = true
        }
    }
}