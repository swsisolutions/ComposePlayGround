package com.swasi.composeplayground.navigation.accountnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swasi.account.AccountScreen
import com.swasi.account.home.AccountHomeScreen
import com.swasi.account.onboarding.OnBoardingScreen
import com.swasi.account.signin.SignInScreen
import com.swasi.account.signup.SignUpScreen
import com.swasi.account.splash.SplashScreen

@Composable
fun AccountNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AccountScreen.Splash.route
    ) {
        composable(AccountScreen.Splash.route) {
            SplashScreen {
                navController.navigate(AccountScreen.OnBoarding)
            }
        }
        composable(AccountScreen.OnBoarding.route) {
            OnBoardingScreen(
                onNavigateToSignIn = { navController.navigate(AccountScreen.SignIn) },
                onNavigateToSignUp = { navController.navigate(AccountScreen.SignUp) }
            )
        }
        composable(AccountScreen.SignIn.route) {
            SignInScreen(
                onNavigateToSignUp = { navController.navigate(AccountScreen.SignIn) },
                onNavigateToForgotPassword = { navController.navigate(AccountScreen.SignIn) },
                onNavigateToHome = {
                    val route = AccountScreen.HomeScreenWithArgument.createRoute(productId = "FROM SignIn")
                    navController.navigate(route)
                },
            )
        }
        composable(AccountScreen.SignUp.route) {
            SignUpScreen(
                onNavigateToSIgnIn = { navController.navigate(AccountScreen.SignIn) },
                onNavigateToHome = { navController.navigate(AccountScreen.SignIn) },
            )
        }
        composable(AccountScreen.HomeScreenWithArgument.route) {
                backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")

            AccountHomeScreen(productId)
        }
    }
}