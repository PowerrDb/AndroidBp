package com.razi.main_repository.mapper

import com.razi.main.model.PopularMovie
import com.razi.main_local.model.PopularMovieEntity
import com.razi.main_remote.dto.PopularMovieDto

fun PopularMovieDto.RemoteMovie.toEntity() = PopularMovieEntity(
    adult = adult,
    backdrop_path = backdropPath,
    id = id,
    original_language = originalLanguage,
    original_title = originalTitle,
    overview = overview,
    popularity = popularity,
    poster_path = posterPath,
    release_date = releaseDate,
    title = title,
    video = video,
    vote_average = voteAverage,
    vote_count = voteCount
)

fun PopularMovieDto.RemoteMovie.toDomain() = PopularMovie(
    adult = adult,
    backdrop_path = backdropPath,
    id = id,
    original_language = originalLanguage,
    original_title = originalTitle,
    overview = overview,
    popularity = popularity,
    poster_path = posterPath,
    release_date = releaseDate,
    title = title,
    video = video,
    vote_average = voteAverage,
    vote_count = voteCount
)


fun PopularMovieEntity.toRemoteMain() = PopularMovieDto.RemoteMovie(
    adult = adult,
    backdropPath = backdrop_path,
    id = id,
    genreIds = listOf(),
    originalLanguage = original_language,
    originalTitle = original_title,
    overview = overview,
    popularity = popularity,
    posterPath = poster_path,
    releaseDate = release_date,
    title = title,
    video = video,
    voteAverage = vote_average,
    voteCount = vote_count
)


fun PopularMovieEntity.toDomainT() = PopularMovie(
    adult = adult,
    backdrop_path = backdrop_path,
    id = id,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)