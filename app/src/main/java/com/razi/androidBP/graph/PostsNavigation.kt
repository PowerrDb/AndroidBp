package com.razi.androidBP.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.razi.compose_sample.navigation.ComposeSampleDestinations
import com.razi.compose_sample.ListOfComposePracticeRoute
import com.razi.navigation.Destinations

fun NavGraphBuilder.composeList(navController: NavController) {

    navigation(
        startDestination = ComposeSampleDestinations.ListOfComposeScreen.route,
        route = Destinations.ComposeSampleScreen.route
    ) {
        composable(ComposeSampleDestinations.ListOfComposeScreen.route) {
            ListOfComposePracticeRoute(navController)

        }
        listAnim()
        taskList()
        basicLayout()
    }


}
