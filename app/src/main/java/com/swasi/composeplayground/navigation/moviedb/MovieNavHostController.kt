package com.swasi.composeplayground.navigation.moviedb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swasi.account.AccountScreen
import com.swasi.account.signin.SignInScreen
import com.swasi.account.signup.SignUpScreen
import com.swasi.moviedb.MovieDbParams
import com.swasi.moviedb.MovieScreen
import com.swasi.moviedb.details.MovieDetailsScreen
import com.swasi.moviedb.fruit.FruitDetailsScreen
import com.swasi.moviedb.fruit.FruitListScreen
import com.swasi.moviedb.home.MovieHomeScreen
import com.swasi.moviedb.movies.MovieListScreen
import com.swasi.moviedb.tvshow.TvShowScreen

@Composable
fun MovieNavHostController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreen.MOVIE_DASHBOARD.route
    ) {
        composable(MovieScreen.MOVIE_DASHBOARD.route) {
            MovieHomeScreen(
                onNavigateToMovieScreen = { navController.navigate(MovieScreen.MOVIE_LIST.route) },
                onNavigateToTvShow = { navController.navigate(MovieScreen.TV_SHOW_LIST.route) },
                onNavigateToFruits = { navController.navigate(MovieScreen.FRUIT_LIST.route) }
            )
        }
        composable(MovieScreen.MOVIE_LIST.route) {
            MovieListScreen(
                navigateToMovieDetails = { name, details ->

                }
            )
        }
        composable(MovieScreen.TV_SHOW_LIST.route) {
            TvShowScreen()
        }
        composable(MovieScreen.FRUIT_LIST.route) {
            FruitListScreen(
                navigateToFruitDetails = { fruitName ->
                    val route =
                        MovieScreen.FRUIT_DETAILS_SCREEN.createRoute(fruitName = fruitName)
                    navController.navigate(route)
                }
            )
        }

        composable(MovieScreen.FRUIT_DETAILS_SCREEN.route) { backStackEntry ->
            val fruitName: String =
                backStackEntry.arguments?.getString(MovieDbParams.FRUIT_NAME) ?: "Null Value"

            FruitDetailsScreen(
                fruitDataInJson = fruitName,
                {},
                {}
            )
        }

        composable(MovieScreen.MOVIE_DETAILS_SCREEN.route) { backStackEntry ->
            val movieDataInJson: String =
                backStackEntry.arguments?.getString(MovieDbParams.FRUIT_NAME) ?: "Null Value"

            MovieDetailsScreen(
                movieDataInJson = movieDataInJson,
                {},
                {}
            )
        }

        composable(AccountScreen.SignIn.route) {
            SignInScreen(
                onNavigateToSignUp = { navController.navigate(AccountScreen.SignIn.route) },
                onNavigateToForgotPassword = { navController.navigate(AccountScreen.SignIn.route) },
                onNavigateToHome = {
                    val route =
                        AccountScreen.HomeScreenWithArgument.createRoute(productId = "FROM SignIn")
                    navController.navigate(route)
                },
            )
        }

        composable(AccountScreen.SignUp.route) {
            SignUpScreen(
                onNavigateToSIgnIn = { navController.navigate(AccountScreen.SignIn.route) },
                onNavigateToHome = { navController.navigate(AccountScreen.SignIn.route) },
            )
        }
    }
}