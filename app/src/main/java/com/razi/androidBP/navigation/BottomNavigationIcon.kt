package com.razi.androidBP.navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationIcon(
    name: String,
    icon: ImageVector,
    selected: Boolean,
    badgeCount: Int,
    hasNews: Boolean,
) {

    BadgedBox(badge = {
        if (badgeCount != 0) {
            Badge {
                Text(text = badgeCount.toString())
            }
        } else if (hasNews) {
            Badge()
        }
    }

    ) {

        Icon(
            imageVector = icon,
            contentDescription = name,
        )

    }
}

