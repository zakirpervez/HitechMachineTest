package com.hitech.hitechmachinetest.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hitech.hitechmachinetest.model.Router
import com.hitech.hitechmachinetest.ui.composable.profile.ProfileReviewScreen
import com.hitech.hitechmachinetest.ui.composable.splash.SplashScreen
import com.hitech.hitechmachinetest.ui.composable.signup.SignUpScreen

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Router.SplashScreen.route,
        builder = {
            composable(route = Router.SplashScreen.route) {
                SplashScreen {
                    navController.popBackStack()
                    navController.navigate(
                        route = Router.SignUpScreen.route,
                    )
                }
            }

            composable(route = Router.SignUpScreen.route) {
                SignUpScreen {
                    navController.popBackStack()
                    navController.navigate(
                        route = Router.ProfileReviewScreen.route
                    )
                }
            }

            composable(route = Router.ProfileReviewScreen.route) {
                ProfileReviewScreen()
            }
        },
    )
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun AppRoutePreview() {
    AppRoute()
}