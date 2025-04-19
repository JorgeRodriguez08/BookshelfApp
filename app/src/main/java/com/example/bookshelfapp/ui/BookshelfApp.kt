package com.example.bookshelfapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfapp.ui.screens.BookTopAppBar
import com.example.bookshelfapp.ui.screens.BookshelfScreen
import com.example.bookshelfapp.viewmodel.BooksViewModel

@Composable
fun BookshelfApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BookTopAppBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val booksViewModel: BooksViewModel = viewModel(factory = BooksViewModel.factory)
            BookshelfScreen(
                booksUiState = booksViewModel.booksUiState,
                retryAction = { booksViewModel.searchBooks() },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}