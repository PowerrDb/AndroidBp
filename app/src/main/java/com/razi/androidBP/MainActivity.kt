package com.razi.androidBP

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.razi.androidBP.navigation.AppNavHost
import com.razi.androidBP.navigation.BottomNavigationBar
import com.razi.androidBP.navigation.rememberBpAppState
import com.razi.designsystem.theme.AndroidbpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberBpAppState()
            AndroidbpTheme {

                Scaffold(bottomBar = {
                    BottomNavigationBar(appState)
                }) { paddingValues ->
                    AppNavHost(
                        appState = appState,
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