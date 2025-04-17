package com.example.bookshelfapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookshelfapp.model.Book

@Composable
fun BooksGridScreen(
    books: List<Book>,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)

) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 0.dp),
        contentPadding = contentPadding
    ) {
        items(items = books) { book ->
            BookCard(book = book, modifier)
        }
    }

}