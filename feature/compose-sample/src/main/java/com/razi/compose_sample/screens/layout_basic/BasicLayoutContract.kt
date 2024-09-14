package com.razi.compose_sample.screens.layout_basic

import com.razi.compose_sample.screens.task_list.TaskItemModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


interface BasicLayoutContract  {

    data class State(
        val dataList: PersistentList<Int> = persistentListOf(),
    )

    sealed class Event {
        data object getData : Event()
    }
}
