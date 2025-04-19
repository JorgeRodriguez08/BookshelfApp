package com.example.bookshelfapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksResponse(
    val kind: String,
    @SerialName ("totalItems") val totalBooks: Int,
    @SerialName ("items") val books: List<Book>
)
