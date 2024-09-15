package com.razi.androidBP.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.razi.androidBP.graph.navigateToComposeList
import com.razi.androidBP.graph.navigateToHome
import com.razi.androidBP.graph.navigateToProfile
import com.razi.navigation.BottomNavItem
import com.razi.navigation.Destinations
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberBpAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): AppState {

    return remember(
        navController,
        coroutineScope,
    ) {
        AppState(
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}

@Stable
class AppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination


    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param bottomNavItem: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(bottomNavItem: BottomNavItem) {

        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (bottomNavItem.route) {
            Destinations.HomeScreen.route -> navController.navigateToHome(topLevelNavOptions)
            Destinations.ProfileScreen.route -> navController.navigateToProfile(topLevelNavOptions)
            Destinations.ComposeSampleScreen.route -> navController.navigateToComposeList(
                topLevelNavOptions
            )
        }

    }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */

    val topLevelDestinations = persistentListOf(
        BottomNavItem(
            title = "Home",
            route = Destinations.HomeScreen.route,
            selectedIcon = Icons.Filled.Home,
            hasNews = false,
            badge = 0
        ),
        BottomNavItem(
            title = "ComposeSamples",
            route = Destinations.ComposeSampleScreen.route,
            selectedIcon = Icons.Filled.Category,
            hasNews = false,
            badge = 0
        ),
        BottomNavItem(
            title = "Profile",
            route = Destinations.ProfileScreen.route,
            selectedIcon = Icons.Filled.AccountCircle,
            hasNews = true,
            badge = 0
        ),
    )


}


