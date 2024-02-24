package com.hitech.hitechmachinetest.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hitech.hitechmachinetest.model.Router
import com.hitech.hitechmachinetest.ui.composable.profile.ProfileReviewScreen
import com.hitech.hitechmachinetest.ui.composable.signup.SignUpScreen
import com.hitech.hitechmachinetest.ui.composable.signup.SignupViewModel
import com.hitech.hitechmachinetest.ui.composable.splash.SplashScreen

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = hiltViewModel()
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
                val signupViewModel = hiltViewModel<SignupViewModel>()
                SignUpScreen(viewModel = signupViewModel) { user ->
                    sharedViewModel.user = user
                    navController.popBackStack()
                    navController.navigate(
                        route = Router.ProfileReviewScreen.route,
                    )
                }
            }

            composable(
                route = Router.ProfileReviewScreen.route
            ) {
                val user = sharedViewModel.user
                ProfileReviewScreen(user = user)
            }
        },
    )
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun AppRoutePreview() {
    AppRoute()
}