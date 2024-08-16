package com.razi.androidBP.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title : String,
    val route : String,
    val selectedIcon : ImageVector,
    val hasNews : Boolean,
    val badge : Int,
)