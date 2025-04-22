package swasi.android.play.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(
            route = Screen.Login.route,
        ) {
            // LoginScreen(navHostController = navController)
        }
        composable(
            route = Screen.SignUp.route
        ) {
            // SignUpScreen(navHostController = navController)
        }
    }

}