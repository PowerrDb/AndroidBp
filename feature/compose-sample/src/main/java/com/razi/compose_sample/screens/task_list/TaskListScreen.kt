package com.razi.compose_sample.screens.task_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskListScreenRoute(modifier: Modifier = Modifier) {
    TaskListScreen()

}

@Composable
fun TaskListScreen(modifier: Modifier = Modifier, taskViewModel: TaskViewModel = hiltViewModel()) {
    val state by taskViewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        taskViewModel.event(TaskContract.Event.getTaskss)
    }
    Column(modifier.statusBarsPadding()) {
        TaskList(
            task = state.taskList,
            onCheckedTask = { task, checked ->
                taskViewModel.event(TaskContract.Event.OnChangeTaskChecked(task, checked))
                            },
            onCloseTask = { taskViewModel.event(TaskContract.Event.OnRemoveItem(it)) },
        )
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskList(
    task: List<TaskItemModel>,
    onCheckedTask: (TaskItemModel, Boolean) -> Unit,
    onCloseTask: (TaskItemModel) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier) {
        items(items = task, key = { it.id }) { task ->
            TaskListItem(
                taskName = task.title,
                checked = task.checked,
                onCheckedChange = { onCheckedTask(task, it) },
                onCloseTask = { onCloseTask(task) },
                isSomething = task.isSomething,
                onClickCard = { task.isSomething = !task.isSomething },
                modifier = modifier.animateItemPlacement()
            )


        }
    }

}

@Composable
fun TaskListItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onCloseTask: () -> Unit,
    onClickCard: () -> Unit,
    isSomething: Boolean,
    modifier: Modifier
) {

    Card(
        onClick = { onClickCard() },
        modifier = modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Row(
                modifier = modifier.padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp,

                )
            ) {
                Text(
                    text = taskName,
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )

                Checkbox(checked = checked, onCheckedChange = onCheckedChange)
                IconButton(onClick = { onCloseTask() }) {
                    Icon(Icons.Filled.Close, contentDescription = "Close")
                }
            }


            AnimatedVisibility(visible = isSomething) {
                Column(modifier = modifier.padding(16.dp)){
                    Text(text = "aaaaaaaaaaaaaaaaaaaaaaaaaa")
                    Text(text = "bbbbbb")
                    Text(text = "cc")
                }

            }
        }

    }

}

@Composable
fun WaterCounter() {
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskListScreenPreview() {
    TaskListScreen(Modifier)
}
