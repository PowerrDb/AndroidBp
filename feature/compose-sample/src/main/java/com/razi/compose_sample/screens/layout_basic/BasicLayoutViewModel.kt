package com.razi.compose_sample.screens.layout_basic

import android.system.Os.remove
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.razi.compose_sample.screens.task_list.TaskItemModel
import kotlinx.collections.immutable.PersistentCollection
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.nio.file.Files.find

class BasicLayoutViewModel : ViewModel() {

    private val mutableState = MutableStateFlow(BasicLayoutContract.State())
    val state: StateFlow<BasicLayoutContract.State> = mutableState.asStateFlow()

    fun event(event: BasicLayoutContract.Event) {
        when (event) {
            is BasicLayoutContract.Event.getData -> {
                mutableState.update {
                    it.copy(dataList = getData() )
                }
            }

        }

    }


   private fun getData(): PersistentList<Int> {
        return persistentListOf<Int>(1,2,3,5,6,9,11,12,13,14,15,16,17,18,19,20)
    }

}