package com.razi.androidBP

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.razi.androidBP.navigation.AppNavHost
import com.razi.androidBP.navigation.BottomNavigationBar
import com.razi.designsystem.theme.AndroidbpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val backStackEntry = navController.currentBackStackEntryAsState()
            val currentScreenRoute = backStackEntry.value?.destination?.route
            AndroidbpTheme {

                Scaffold(bottomBar = {
                    BottomNavigationBar(items = bottomNavItems,
                        currentScreenRoute = currentScreenRoute,
                        onItemClick = {
                            navController.navigate(it.route)
                        })
                }) { paddingValues ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidbpTheme {

    }
}