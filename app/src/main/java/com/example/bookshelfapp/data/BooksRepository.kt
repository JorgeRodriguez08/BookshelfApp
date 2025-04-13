package com.example.bookshelfapp.data

import com.example.bookshelfapp.model.Book

interface BooksRepository {
    suspend fun getBooks() : String/*List<Book>*/
}