package com.swasi.account

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private object Route {
    const val SPLASH = "splash"
    const val SIGNIN = "signIN"
    const val SIGNUP = "signUp"
    const val ONBOARDING = "onBoarding"
    const val HOME = "home"
    const val HOME_WITH_ARGUMENT = "home/{${ArgParams.PRODUCT_ID}}"
}

sealed class AccountScreen(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {
    data object Splash: AccountScreen(Route.SPLASH)
    data object SignIn: AccountScreen(Route.SIGNIN)
    data object SignUp: AccountScreen(Route.SIGNUP)
    data object OnBoarding: AccountScreen(Route.ONBOARDING)
    data object HomeScreenWithArgument : AccountScreen(
        Route.HOME_WITH_ARGUMENT,
        navArguments = listOf(navArgument(ArgParams.PRODUCT_ID) {
            type = NavType.Companion.StringType
        })
    ) {
        fun createRoute(productId: String) =
            Route.HOME_WITH_ARGUMENT
                .replace(ArgParams.toPath(ArgParams.PRODUCT_ID), productId
                )
    }
}

object ArgParams {
    const val PRODUCT_ID = "productId"

    fun toPath(param: String) = "{${param}}"
}