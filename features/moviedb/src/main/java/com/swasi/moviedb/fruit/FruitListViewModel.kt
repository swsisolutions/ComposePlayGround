package com.swasi.moviedb.fruit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.swasi.moviedb.R
import com.swasi.moviedb.state.UiState
import javax.inject.Inject

/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class FruitListViewModel @Inject constructor() : ViewModel() {

    private var page = 0
    private var _fruitListState = MutableStateFlow<UiState<FruitData>>(UiState.Loading)
    val fruitListState = _fruitListState.asStateFlow()
    private var listData = mutableListOf<FruitData>()

    private fun getFruitListFromServer(): MutableList<FruitData> {
        val fruitsList = mutableListOf<FruitData>()
        fruitsList.add(FruitData(id = 0, "Apple $page", R.drawable.apple))
        fruitsList.add(FruitData(id = 1, "Orange $page", R.drawable.orange))
        fruitsList.add(FruitData(id = 2, "Banana $page", R.drawable.banana))
        fruitsList.add(FruitData(id = 3, "Strawberry $page", R.drawable.strawberry))
        fruitsList.add(FruitData(id = 4, "Mango $page", R.drawable.mango))
        fruitsList.add(FruitData(id = 5, "pomegranate $page", R.drawable.pomegranate))
        fruitsList.add(FruitData(id = 6, "Grapes $page", R.drawable.grapes))
        fruitsList.add(FruitData(id = 7, "Avocado $page", R.drawable.avocado))
        fruitsList.add(FruitData(id = 8, "Pears $page", R.drawable.pears))
        fruitsList.add(FruitData(id = 9, "Kiwi $page", R.drawable.kiwi))
        fruitsList.add(FruitData(id = 10, "Jack fruit $page", R.drawable.jackfruit))
        fruitsList.add(FruitData(id = 11, "Pine Apple $page", R.drawable.pineapple))
        page++
        return fruitsList
    }

    fun loadFruits() {
        viewModelScope.launch {
            _fruitListState.value = UiState.Loading
            delay(5000L)
            try {
                listData.addAll(getFruitListFromServer())
                _fruitListState.value = UiState.Data(listData)
            } catch (e: Exception) {
                _fruitListState.value = UiState.Error(e.message!!)
            }
        }
    }
}