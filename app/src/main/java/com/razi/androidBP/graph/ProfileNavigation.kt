package com.razi.androidBP.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.razi.navigation.Destinations
fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(Destinations.ProfileScreen.route, navOptions)

fun NavGraphBuilder.profile() {
    composable(Destinations.ProfileScreen.route) {
        Text(
            text = "Pooooosts",
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 320.dp),
            textAlign = TextAlign.Center
        )
    }
}