package com.razi.popular_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.razi.main.model.Resource
import com.razi.main.useCase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel(), MovieListContract {

    private val mutableState = MutableStateFlow(MovieListContract.State())

    val state: StateFlow<MovieListContract.State> = mutableState.asStateFlow()

    fun event(event: MovieListContract.Event) {
        when (event) {
            MovieListContract.Event.OnGetMovieList -> {
                getPopularMovie()
            }

            MovieListContract.Event.OnRefresh -> {
                getPopularMovie()
            }
        }

    }


    private fun getPopularMovie() {
        mutableState.update { it.copy(loading = true) }
        viewModelScope.launch {
            useCase.getPopularMovies().onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        mutableState.update {
                            it.copy(
                                error = result.exception?.localizedMessage
                                    ?: "An unexpected error occurred."
                            )
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { data ->
                            mutableState.update {
                                it.copy(movieList = data.toPersistentList(), loading = false)
                            }
                        }
                    }
                }

            }.catch { exception ->
                mutableState.update {
                    it.copy(
                        error = exception.localizedMessage ?: "An unexpected error occurred."
                    )
                }
            }.launchIn(viewModelScope)

        }


    }

}