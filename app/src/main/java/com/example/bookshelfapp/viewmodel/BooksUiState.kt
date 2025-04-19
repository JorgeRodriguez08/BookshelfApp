package com.example.bookshelfapp.viewmodel

import com.example.bookshelfapp.model.Book

sealed interface BooksUiState {
    data object Error: BooksUiState
    data class Success(val books: List<Book>): BooksUiState
    data object Loading: BooksUiState
}