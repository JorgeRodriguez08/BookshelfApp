package com.example.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfapp.ui.theme.BookshelfAppTheme
import com.example.bookshelfapp.viewmodel.BooksViewModel.Companion.factory
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewModelScope
import com.example.bookshelfapp.viewmodel.BooksUiState
import com.example.bookshelfapp.viewmodel.BooksViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookshelfAppTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   Library()
               }
            }
        }
    }
}


@Composable
fun Library(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val booksViewModel: BooksViewModel = viewModel(factory = factory)
        val booksUiState: BooksUiState = booksViewModel.booksUiState

        when(booksUiState) {
            is BooksUiState.Loading -> Books(books = "Loading", modifier = Modifier.padding(innerPadding))
            is BooksUiState.Success -> Books(books = booksUiState.books, modifier = Modifier.padding(innerPadding))
            is BooksUiState.Error -> Books(books = "Error", modifier = Modifier.padding(innerPadding))
        }
    }
}



@Composable
fun Books(books: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 40.dp)
    ) {
        Text(
        text = "Hello Android Developer:\n$books\n", textAlign = TextAlign.Center,
        modifier = modifier)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    BookshelfAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Books(books = "Jorge")
        }

    }
}