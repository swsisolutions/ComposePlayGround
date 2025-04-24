package com.swasi.sideeffect.launchedeffect

import androidx.lifecycle.ViewModel
import com.swasi.ui.common.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LaunchedEffectViewModel : ViewModel() {
    private val dataListState = MutableStateFlow<Resource<LaunchedDataList>>(Resource.Loading)
    val dataListFlow = dataListState.asStateFlow()
    suspend fun getStaticDataList() {
        dataListState.value = Resource.Loading
        delay(5000)
        coroutineScope {
            val list = mutableListOf<LaunchedData>()
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach {
                list.add(LaunchedData("Name $it", description = "Description$it"))
            }
            dataListState.value = Resource.Success(LaunchedDataList(list))
        }
    }
}