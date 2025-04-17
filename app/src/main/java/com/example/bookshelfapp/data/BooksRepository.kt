package com.example.bookshelfapp.data

import com.example.bookshelfapp.model.Book

interface BooksRepository {

    suspend fun getBooks() : List<Book>

    suspend fun getBookById(id: String) : Book

}