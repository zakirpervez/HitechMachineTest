package com.hitech.hitechmachinetest.model

sealed class Router(val route: String) {
    data object SplashScreen : Router(route = "SPLASH_SCREEN")
    data object SignUpScreen : Router(route = "SIGNUP_SCREEN")
    data object ProfileReviewScreen : Router(route = "PROFILE_REVIEW_SCREEN")
}