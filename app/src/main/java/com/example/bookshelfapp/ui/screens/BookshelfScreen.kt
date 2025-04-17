package com.example.bookshelfapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelfapp.ui.screens.BooksGridScreen
import com.example.bookshelfapp.viewmodel.BooksUiState


@Composable
fun BookshelfScreen(
    booksUiState: BooksUiState,
    modifier: Modifier,
    contentPadding: PaddingValues
) {
    when(booksUiState) {

        is BooksUiState.Success -> BooksGridScreen(booksUiState.books, modifier)
        else -> LoadingScreen()
    }
}

