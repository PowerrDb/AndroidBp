package com.razi.main_repository.mapper

import com.razi.main_local.model.MainEntity
import com.razi.main_remote.dto.RemoteMain

fun RemoteMain.toEntity() = MainEntity(
    id = id.toInt(),
    description = longDescription,
    title = shortDescription,
    imageUrl = url,
    dateAdded = name.toLong(),
)



fun MainEntity.toRemoteMain() = RemoteMain(
    id = id.toString() ,
    longDescription  = description,
    shortDescription =title ,
    url = imageUrl,
 )