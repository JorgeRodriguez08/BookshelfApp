package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.Book
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BooksApiService {
    @GET ("/volumes?q=jazz+history")
    suspend fun getBooks() : String/*List<Book>*/

    @GET ("/volumes")
    suspend fun getDynamicBook(
        @Query("q") q: String = "jazz+history"
    ) : String/*List<Book>*/

    @GET("/volumes/{id}")
    suspend fun getImageBook(
        @Path("id") id: String
    )

}