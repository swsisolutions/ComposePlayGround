package swasi.android.play.navigation

import android.app.Person
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation

@Composable
fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            //  HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
            Log.d("Args", "the argument is ${it.arguments?.getInt(DETAIL_ARGUMENT_KEY)}")
            Log.d("Args", "the argument is ${it.arguments?.getString(DETAIL_ARGUMENT_KEY2)}")
//            Log.d("Args", "the result  is ${result?.firstName} ${result?.secondName}")


            // DetailsScreen(navController)
        }
    }
}