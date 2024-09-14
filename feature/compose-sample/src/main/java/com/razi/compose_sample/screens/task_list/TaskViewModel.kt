package com.razi.compose_sample.screens.task_list

import android.system.Os.remove
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.nio.file.Files.find

class TaskViewModel : ViewModel() {

   //private val _tasks = getTaskss().toMutableStateList()
   //val tasks: List<TaskItemModel>
   //    get() = _tasks


    private val mutableState = MutableStateFlow(TaskContract.State())
    val state: StateFlow<TaskContract.State> = mutableState.asStateFlow()

    fun event(event: TaskContract.Event) {
        when (event) {
            is TaskContract.Event.OnChangeTaskChecked -> {
                changeTaskChecked(event.item, event.checked)
            }

            is TaskContract.Event.OnRemoveItem -> {
                remove(event.item)
            }
            is TaskContract.Event.getTaskss -> {
                mutableState.update { it.copy(getTaskss().toPersistentList()) }
            }
        }

    }

    private fun changeTaskChecked(item: TaskItemModel, checked: Boolean)  {
        mutableState.value.taskList.find { it.id == item.id  }?.let { task ->
            task.checked = checked
        }
        mutableState.update {
            it.copy(taskList = it.taskList.toPersistentList() )
        }
    }






    private fun remove(item: TaskItemModel) {
        mutableState.update {
            it.copy(taskList = it.taskList.filter { it.id != item.id }.toPersistentList())
        }
    }

    private fun getTaskss() = List(30) { i -> TaskItemModel(i, "Task # $i") }

}