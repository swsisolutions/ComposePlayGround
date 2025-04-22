package com.swasi.account.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    val isLoading = mutableStateOf(false)
    fun signUp() {
        isLoading.value = true
    }

}