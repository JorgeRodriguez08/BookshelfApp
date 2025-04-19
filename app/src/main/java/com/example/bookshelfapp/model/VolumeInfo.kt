package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String,
    val description: String? = null,
    val imageLinks: ImageLinks? = null
)
