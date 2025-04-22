package swasi.android.play.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.swasi.ui.components.AppTextView
import com.swasi.ui.theme.ComposePlaygroundTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationScreen()
        }
    }
}

@Composable
fun NavigationScreen() {
    val view = LocalView.current
    ComposePlaygroundTheme {
//        val window = (view.context as Activity).window
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "about") {
            composable("about") {
                ScreenWithNavigation(
                    screenName = "About Us",
                    leftButton = "Auth",
                    rightButton = "Calendar",
                    onLeftButtonClick = {
                        navController.navigate(
                            route = "auth"
                        ) {
                            popUpTo("auth") {
                                inclusive = true // it will be pup up from back stack
                            }
                        }
                    },
                    onRightButtonClick = {
                        navController.navigate(
                            route = "product"
                        ) {
                            popUpTo("product") {
                                inclusive = true // it will be pup up from back stack
                            }
                        }
                    }
                )
            }
            navigation(
                startDestination = "Login",
                route = "auth"
            ) {
                composable("login") {
//                    val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                    ScreenWithNavigation(
                        screenName = "Login Screen",
                        leftButton = "Register",
                        rightButton = "Forgot Password",
                        onLeftButtonClick = {
                            navController.navigate(
                                route = "register"
                            ) {
                                popUpTo("auth") {
                                    inclusive = true // it will be pup up from back stack
                                }
                            }
                        },
                        onRightButtonClick = {
                            navController.navigate(
                                route = "forgotpassword"
                            ) {
                                popUpTo("auth") {
                                    inclusive = true // it will be pup up from back stack
                                }
                            }
                        }
                    )
                }
                composable("register") {
                    // val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                    ScreenWithNavigation(
                        screenName = "Register Screen",
                        leftButton = "Login",
                        rightButton = "ForgotPassword",
                        onLeftButtonClick = {
                            navController.navigate(
                                "login"
                            ) {
                                popUpTo("auth") {
                                    inclusive = true // it will be pup up from back stack
                                }
                            }
                        },
                        onRightButtonClick = {
                            navController.navigate(
                                route = "forgotpassword"
                            ) {
                                popUpTo("auth") {
                                    inclusive = true // it will be pup up from back stack
                                }
                            }
                        }
                    )
                }
                composable("forgotpassword") {
                    //  val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                    ScreenWithNavigation(
                        screenName = "About Us",
                        leftButton = "Auth",
                        rightButton = "product",
                        onLeftButtonClick = {},
                        onRightButtonClick = {}
                    )
                }
            }

            navigation(
                startDestination = "productList",
                route = "product"
            ) {
                composable("productList") {
                    ScreenWithNavigation(
                        screenName = "Product List",
                        leftButton = "Auth",
                        rightButton = "productDetails",
                        onLeftButtonClick = {
                            navController.navigate(
                                route = "auth"
                            )
                        },
                        onRightButtonClick = {
                            navController.navigate(
                                route = "productDetails"
                            )
                        }
                    )
                }
                composable("productDetails") {
                    ScreenWithNavigation(
                        screenName = "Product Details",
                        leftButton = "productList",
                        rightButton = "productList",
                        onLeftButtonClick = {
                            navController.navigate(
                                route = "productList"
                            )
                        },
                        onRightButtonClick = {}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NavigationScreenPreview() {
    NavigationScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWithNavigation(
    screenName: String,
    leftButton: String,
    rightButton: String,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text(text = screenName) },
            navigationIcon = {
                Icon(Icons.Filled.Menu, "menu", modifier = Modifier.clickable {

                })
            },
            modifier = Modifier.align(Alignment.TopCenter)
        )

        AppTextView(
            text = screenName, color = Color.Black, modifier = Modifier.align(
                Alignment.Center
            )
        )

        Button(
            onClick = { onLeftButtonClick() },
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(text = leftButton)
        }
    }
}

@Composable
fun <T> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}