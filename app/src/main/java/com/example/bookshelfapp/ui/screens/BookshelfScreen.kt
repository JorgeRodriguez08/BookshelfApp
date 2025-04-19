package com.example.bookshelfapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.bookshelfapp.R
import com.example.bookshelfapp.viewmodel.BooksUiState

@Composable
fun BookshelfScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(dimensionResource(R.dimen.padding_extra_small))
) {
    when(booksUiState) {
        is BooksUiState.Loading -> LoadingScreen()
        is BooksUiState.Success -> BooksGridScreen(
            booksUiState.books,
            modifier = modifier,
            contentPadding = contentPadding
        )
        else -> ErrorScreen(retryAction = retryAction)
    }
}

