package com.swasi.account.signin

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
class SignInViewModel @Inject constructor() : ViewModel() {

    val isLoading = mutableStateOf(false)
    val loadHomeScreen = mutableStateOf(false)

    fun signIn() {
        viewModelScope.launch {
            isLoading.value = true
            delay(5000L)
            loadHomeScreen.value = true
        }
    }
}