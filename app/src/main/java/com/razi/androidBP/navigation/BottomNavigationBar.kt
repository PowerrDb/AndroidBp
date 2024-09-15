package com.razi.androidBP.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.razi.navigation.BottomNavItem

@Composable
fun BottomNavigationBar(
    appState: AppState,
    modifier: Modifier = Modifier,

    ) {
    val currentDestination = appState.currentDestination
    NavigationBar(
        modifier = modifier, tonalElevation = 15.dp
    ) {

        appState.topLevelDestinations.forEach { item ->

            val selected = currentDestination.isTopLevelDestinationInHierarchy(item)

            NavigationBarItem(selected = selected,
                onClick = { appState.navigateToTopLevelDestination(item) },
                icon = {
                    BottomNavigationIcon(
                        name = item.title,
                        icon = item.selectedIcon,
                        badgeCount = item.badge,
                        hasNews = item.hasNews,
                    )
                },
                label = {
                    Text(text = item.title)
                })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: BottomNavItem) =
    this?.hierarchy?.any {
        it.route?.contains(destination.route, true) ?: false
    } ?: false
