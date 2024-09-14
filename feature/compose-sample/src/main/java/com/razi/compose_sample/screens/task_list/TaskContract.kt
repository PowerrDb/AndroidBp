package com.razi.compose_sample.screens.task_list

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


interface TaskContract  {

    data class State(
        val taskList: PersistentList<TaskItemModel> = persistentListOf(),
    )

    sealed class Event {
        data class OnChangeTaskChecked(val item: TaskItemModel, val checked: Boolean) : Event()
        data class OnRemoveItem(val item: TaskItemModel) : Event()
        data object getTaskss : Event()
    }
}
