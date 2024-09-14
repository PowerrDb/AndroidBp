package com.razi.compose_sample.screens.task_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TaskItemModel(val id: Int, val title: String, initialChecked: Boolean = false, isSomething : Boolean = false) {
    var checked by mutableStateOf(initialChecked)
    var isSomething by mutableStateOf(isSomething)
}