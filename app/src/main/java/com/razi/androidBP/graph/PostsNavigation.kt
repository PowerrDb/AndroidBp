package com.razi.androidBP.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.postsList() {
    composable("post") {
        Text(
            text = "Pooooosts",
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 220.dp),
            textAlign = TextAlign.Center
        )
    }
}