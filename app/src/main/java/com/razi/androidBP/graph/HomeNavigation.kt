package com.razi.androidBP.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.razi.navigation.Destinations
import com.razi.popular_movie.PopularMovieScreenRout
fun NavController.navigateToHome(navOptions: NavOptions) = navigate(Destinations.HomeScreen.route, navOptions)

fun NavGraphBuilder.homeList() {
    composable(Destinations.HomeScreen.route) {
        PopularMovieScreenRout()
    }
}
