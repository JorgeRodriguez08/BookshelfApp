package com.example.bookshelfapp.data

import com.example.bookshelfapp.network.BooksApiService

class JazzBooksRepository(val booksApiService: BooksApiService) : BooksRepository {
    override suspend fun getBooks() = booksApiService.getBooks()
}