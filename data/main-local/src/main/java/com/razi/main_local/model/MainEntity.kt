package com.razi.main_local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MainEntity(
    var title: String,
    var description: String,
    var imageUrl: String,

    var dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)