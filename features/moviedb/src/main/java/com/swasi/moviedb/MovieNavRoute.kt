package com.swasi.moviedb

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private object MovieNavRoute {
    const val MOVIE_DASHBOARD = "MovieDashBoard"
    const val MOVIE_LIST = "MovieList"
    const val TV_SHOW_LIST = "TvSHowList"
    const val FRUIT_LIST = "FruitList"
    const val FRUIT_DETAILS = "FruitDetails{${MovieDbParams.FRUIT_NAME}}"
    const val MOVIE_DETAILS = "MovieDetails{${MovieDbParams.MOVIE_DATA}}"
}

object MovieDbParams {
    const val MOVIE_DATA = "MovieData"
    const val FRUIT_NAME = "FruitName"
    fun toFruitPath(fruitName: String) = "{${fruitName}}"
    fun toPath(movieData: String) = "{${movieData}}"
}

sealed class MovieScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object MOVIE_DASHBOARD : MovieScreen(MovieNavRoute.MOVIE_DASHBOARD)
    data object MOVIE_LIST : MovieScreen(MovieNavRoute.MOVIE_LIST)
    data object FRUIT_LIST : MovieScreen(MovieNavRoute.FRUIT_LIST)
    data object TV_SHOW_LIST : MovieScreen(MovieNavRoute.TV_SHOW_LIST)
    data object FRUIT_DETAILS_SCREEN : MovieScreen(
        MovieNavRoute.FRUIT_DETAILS,
        navArguments = listOf(navArgument(MovieDbParams.FRUIT_NAME) {
            type = NavType.Companion.StringType
        })
    ) {
        fun createRoute(fruitName: String) =
            MovieNavRoute.FRUIT_DETAILS
                .replace(
                    MovieDbParams.toFruitPath(MovieDbParams.FRUIT_NAME), fruitName
                )
    }

    data object MOVIE_DETAILS_SCREEN : MovieScreen(
        MovieNavRoute.MOVIE_DETAILS,
        navArguments = listOf(navArgument(MovieDbParams.MOVIE_DATA) {
            type = NavType.Companion.StringType
        })
    ) {
        fun createMovieDetailsWithJsonData(movieDataInJson: String) =
            MovieNavRoute.MOVIE_DETAILS
                .replace(
                    MovieDbParams.toFruitPath(MovieDbParams.MOVIE_DATA), movieDataInJson
                )
    }
}