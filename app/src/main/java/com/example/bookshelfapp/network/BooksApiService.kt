package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.Book
import retrofit2.http.GET


interface BooksApiService {
    @GET ("q")
    suspend fun getBooks() : String/*List<Book>*/
}