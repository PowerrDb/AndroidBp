package com.razi.androidBP.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.razi.compose_sample.navigation.ComposeSampleDestinations
import com.razi.compose_sample.screens.layout_basic.LayoutBasicScreenRoute


fun NavGraphBuilder.basicLayout() {
    composable(ComposeSampleDestinations.BasicLayoutScreen.route) {
        LayoutBasicScreenRoute()
    }
}