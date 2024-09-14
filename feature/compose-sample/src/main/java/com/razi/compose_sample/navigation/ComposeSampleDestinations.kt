package com.razi.compose_sample.navigation

sealed class ComposeSampleDestinations(val route: String) {
    data object ListOfComposeScreen : ComposeSampleDestinations("list_of_compose_screen")
    data object ListWithAnimScreen : ComposeSampleDestinations("list_with_anim_screen")
    data object TaskListScreen : ComposeSampleDestinations("task_list_screen")
    data object BasicLayoutScreen : ComposeSampleDestinations("basic_layout_screen")

}
