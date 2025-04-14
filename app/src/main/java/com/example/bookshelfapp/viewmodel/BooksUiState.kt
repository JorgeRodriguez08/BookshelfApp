package com.example.bookshelfapp.viewmodel

sealed interface BooksUiState {
    data object Error: BooksUiState
    data class Success(val books: String/*List<Book>*/): BooksUiState
    data object Loading: BooksUiState
}