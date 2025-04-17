package com.example.bookshelfapp.data

import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import com.example.bookshelfapp.network.BooksApiService

class BooksAppContainer : AppContainer {

    private val baseUrl = "https://www.googleapis.com/books/v1/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    val booksApiService: BooksApiService by lazy { retrofit.create(BooksApiService::class.java) }

    override val jazzBooksRepository: BooksRepository by lazy { JazzBooksRepository(booksApiService) }
}