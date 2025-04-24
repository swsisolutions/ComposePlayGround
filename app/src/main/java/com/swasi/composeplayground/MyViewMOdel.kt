package com.swasi.composeplayground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewMOdel: ViewModel() {

    val sharedValue = MutableStateFlow<String>("")

    fun printIsPalindrom() {
        val str = "ABA"
        Log.i("TAG", "Is Palindrom ${str.isPallindrom()}")
    }

    private fun funMoveItemToEndOfList(
        list: List<Any>,
        inputString: Any
    ) {

        val filteredItem = list.filter {
            it == inputString
        }

        val notFiltered = list.filterNot {
            it == inputString
        }.toMutableList()

        if (filteredItem.isNotEmpty()) {
        }

    }

    fun getMultipleAPiCallData() {

        val exceptioonHandler = CoroutineExceptionHandler
        val result1 = viewModelScope.async {
            withContext(Dispatchers.IO) {
                apiCall1()
            }
        }
    }

    suspend fun apiCall1() {

    }

    suspend fun apiCall2() {

    }
}

fun String.isPallindrom() = this.reversed() == this

