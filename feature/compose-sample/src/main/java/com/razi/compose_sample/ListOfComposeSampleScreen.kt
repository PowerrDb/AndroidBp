package com.razi.compose_sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.razi.compose_sample.navigation.ComposeSampleDestinations

@Composable
fun ListOfComposePracticeRoute(navController: NavController) {
    MainScreen(modifier = Modifier.statusBarsPadding(), onClick = { route ->
        navController.navigate(route)
    })
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onClick: (route: String) -> Unit) {

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ElevatedButton(onClick = { onClick(ComposeSampleDestinations.ListWithAnimScreen.route) }) {
                Text(text = "Simple list with animation")
            }
            ElevatedButton(onClick = { onClick(ComposeSampleDestinations.ListWithAnimScreen.route) }) {
                Text(text = "Second Sample")
            }
            ElevatedButton(onClick = { onClick(ComposeSampleDestinations.ListWithAnimScreen.route) }) {
                Text(text = "Third Sample")
            }
        }
    }
}


