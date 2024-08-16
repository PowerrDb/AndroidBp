package com.razi.popular_movie

import com.razi.main.model.PopularMovie
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.StateFlow
import java.lang.Error


interface MovieListContract  {

    data class State(
        val movieList: PersistentList<PopularMovie> = persistentListOf(),
        val loading: Boolean = true,
        val refreshing: Boolean = false,
        val error: String?="",
    )

    sealed class Event {
        data object OnGetMovieList : Event()
        data object OnRefresh : Event()
    }
}
