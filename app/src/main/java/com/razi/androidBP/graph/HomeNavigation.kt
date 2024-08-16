package com.razi.androidBP.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.razi.popular_movie.PopularMovieScreenRout

fun NavGraphBuilder.homeList() {
    composable("home") {
        PopularMovieScreenRout()
    }
}
