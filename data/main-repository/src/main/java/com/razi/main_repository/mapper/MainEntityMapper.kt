package com.razi.main_repository.mapper

import com.razi.main.model.MainDataModel
import com.razi.main_local.model.MainEntity


fun MainEntity.toMainDataModel() = MainDataModel(
    id = id?.toInt(),
    description = description,
    dateAdded = dateAdded,
    title = title,
    imageUrl = imageUrl
)