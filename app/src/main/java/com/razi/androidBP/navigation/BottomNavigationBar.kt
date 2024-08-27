package com.razi.androidBP.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList

@Composable
fun BottomNavigationBar(
    items: PersistentList<BottomNavItem>,
    currentScreenRoute: String?,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    NavigationBar(
        modifier = modifier, tonalElevation = 15.dp
    ) {
        items.forEach { item ->
            val selected = remember {item.route == currentScreenRoute}
            NavigationBarItem(selected = selected, onClick = { onItemClick(item) }, icon = {
                BottomNavigationIcon(
                    name = item.title,
                    icon = item.selectedIcon,
                    badgeCount = item.badge,
                    hasNews = item.hasNews,
                )
            }, label = {
                Text(text = item.title)
            })
        }
    }
}