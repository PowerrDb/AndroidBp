package com.razi.main_remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMain(
    @SerialName("id") val id: String,
   @SerialName("name") val name: String = "",
   @SerialName("shortDescription") val shortDescription: String = "",
   @SerialName("longDescription") val longDescription: String = "",
   @SerialName("url") val url: String = "",
   @SerialName("imageUrl") val imageUrl: String = "",
   @SerialName("followed") val followed: Boolean = false,
)