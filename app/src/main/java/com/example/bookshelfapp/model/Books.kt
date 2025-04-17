package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Books(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>
)
