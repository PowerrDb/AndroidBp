package com.razi.popular_movie

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.razi.designsystem.theme.AndroidbpTheme
import com.razi.main.model.PopularMovie

@Composable
fun PopularMovieScreenRout(
    viewModel: MoviePopularViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.event(MovieListContract.Event.OnGetMovieList)

    }
    if (state.loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else {
        PopularMovieScreen(state = state)
    }
}


@Composable
fun PopularMovieScreen(
    state: MovieListContract.State
) {
    val context = LocalContext.current
    val contextStableWrapper = StableWrapper(context)
    if (state.loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else {
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            state = listState
        ) {
            items(items = state.movieList, key = { it.title }) {
                MovieItem(movieList = it, contextStableWrapper)

            }

        }

    }
}

@Composable
fun MovieItem(movieList: PopularMovie, contextStableWrapper: StableWrapper<Context>) {

    val model by remember {
        mutableStateOf(
            ImageRequest.Builder(contextStableWrapper.value)
                .data("https://image.tmdb.org/t/p/w500${movieList.poster_path}")
                .size(coil.size.Size.ORIGINAL).build()
        )
    }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(480.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()
        ) {

            AsyncImage(
                model = model,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp)),
                contentDescription = "Image Description",
                contentScale = ContentScale.Crop,
            )
            MovieInfoItem(movieList)
        }

    }
}

@Composable
private fun MovieInfoItem(movieList: PopularMovie) {
    Column(
        horizontalAlignment = Alignment.Start, modifier = Modifier
            .height(240.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colorScheme.inverseOnSurface.copy(alpha = 1f)
                    )
                )
            )
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(120.dp))

        Text(
            modifier = Modifier.padding(top = 6.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            text = movieList.title,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .padding(top = 6.dp)
                .align(Alignment.End),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            text = movieList.overview,
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PopularMovieScreenPreview() {
    AndroidbpTheme {
        Surface {
            Column(
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(Color.Gray)
            ) {
                //Item()
            }


        }
    }
}