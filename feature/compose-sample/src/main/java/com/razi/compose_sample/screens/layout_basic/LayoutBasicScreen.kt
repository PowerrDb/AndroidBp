package com.razi.compose_sample.screens.layout_basic

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.razi.compose_sample.R
import com.razi.compose_sample.screens.task_list.TaskContract
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


@Composable
fun LayoutBasicScreenRoute( viewModel: BasicLayoutViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.event(BasicLayoutContract.Event.getData)
    }
    LayoutBasicScreen(state)
}
@Composable
fun LayoutBasicScreen(state : BasicLayoutContract.State,modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .statusBarsPadding()
        .verticalScroll(rememberScrollState())){
        SearchBar(Modifier.padding(16.dp))
        HomeSection(modifier = modifier, title =  R.string.fc2_nature_meditations){
            FavoriteCollectionsGrid(modifier)
        }
        HomeSection(modifier = modifier, title =  R.string.fc4_self_massage){
            AlignYourBodyRow(modifier,state)
        }
        Spacer(Modifier.height(16.dp))
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    list: BasicLayoutContract.State
){
    val listState = rememberLazyListState()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        state = listState,
         modifier = modifier
    ) {

        items(list.dataList, key = {it.toString()}){
            AlignYourBodyElement()
        }
    }
}



@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.fc2_nature_meditations),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)

        )
        Text(
            text = "AlignYourBody",
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
){
    
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .height(168.dp)
        ) {
        items(20){
            FavoriteCollectionCard()
        }
    }
    
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier
) {

    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .height(80.dp)
            .padding(start = 8.dp, end = 8.dp)) {
        Row(
            modifier = Modifier.width(255.dp),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Image(  painter = painterResource(R.drawable.fc2_nature_meditations), contentDescription =null, contentScale = ContentScale.FillBounds, modifier = Modifier.size(80.dp))
            Text(
                text = "Text",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
                )
        }
    }

}


@Composable
fun HomeSection(
    @StringRes title : Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()

    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LayoutBasicScreenPreview(modifier: Modifier = Modifier) {
    FavoriteCollectionsGrid()
}