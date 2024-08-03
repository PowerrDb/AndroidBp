package com.razi.main.model


data class MainDataModel(
    var title: String,
    var description: String,
    var imageUrl: String,
    var dateAdded: Long,
    val id: Int? = null,
)