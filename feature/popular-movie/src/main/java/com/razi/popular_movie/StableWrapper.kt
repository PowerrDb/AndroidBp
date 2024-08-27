package com.razi.popular_movie

import androidx.compose.runtime.Stable

@Stable
data class StableWrapper<T>(val value: T)