package com.razi.androidBP.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.razi.compose_sample.navigation.ComposeSampleDestinations
import com.razi.compose_sample.screens.PracticeListWithAnim
import com.razi.compose_sample.screens.task_list.TaskListScreenRoute


fun NavGraphBuilder.taskList() {
    composable(ComposeSampleDestinations.TaskListScreen.route) {
        TaskListScreenRoute()
    }
}