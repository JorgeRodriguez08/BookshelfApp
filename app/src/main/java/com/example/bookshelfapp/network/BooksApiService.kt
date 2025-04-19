package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.Book
import com.example.bookshelfapp.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {

    @GET ("volumes")
    suspend fun getBooksResponse(@Query ("q") q: String = "jazz+history") : BooksResponse

    @GET ("volumes/{volume_id}")
    suspend fun getBookById(@Path ("volume_id") volumeId: String) : Book

}