package com.razi.main.model

import androidx.compose.runtime.Immutable

@Immutable
data class MainDataModel(
    var title: String,
    var description: String,
    var imageUrl: String,
    var dateAdded: Long,
    val id: Int? = null,
)