/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.razi.androidBP

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import com.razi.navigation.BottomNavItem
import com.razi.navigation.Destinations
import kotlinx.collections.immutable.persistentListOf

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
val bottomNavItems = persistentListOf(
    BottomNavItem(
        title = "Home", route = Destinations.HomeScreen.route, selectedIcon = Icons.Filled.Home, hasNews = false, badge = 0
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
