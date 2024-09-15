package com.razi.androidBP.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.razi.compose_sample.navigation.ComposeSampleDestinations
import com.razi.compose_sample.screens.PracticeListWithAnim
import com.razi.navigation.Destinations

fun NavController.navigateToComposeList(navOptions: NavOptions) = navigate(Destinations.ComposeSampleScreen.route, navOptions)

fun NavGraphBuilder.listAnim() {
    composable(ComposeSampleDestinations.ListWithAnimScreen.route) {
        PracticeListWithAnim()
    }
}