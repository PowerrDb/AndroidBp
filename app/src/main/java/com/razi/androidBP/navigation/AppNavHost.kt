package com.razi.androidBP.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.razi.navigation.Destinations
import com.razi.androidBP.graph.homeList
import com.razi.androidBP.graph.composeList
import com.razi.androidBP.graph.profile

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HomeScreen.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {

        homeList()
        composeList (navController)
        profile()
    }
}