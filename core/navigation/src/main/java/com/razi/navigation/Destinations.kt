package com.razi.navigation

sealed class Destinations(val route: String) {
    data object HomeScreen : Destinations("home_screen")
    data object ComposeSampleScreen : Destinations("compose_sample_screen")
    data object ProfileScreen : Destinations("profile_screen")
}
