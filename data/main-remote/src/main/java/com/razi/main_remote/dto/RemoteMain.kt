package com.razi.main_remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RemoteMain(
    val id: String,
    val name: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val url: String = "",
    val imageUrl: String = "",
    val followed: Boolean = false,
)