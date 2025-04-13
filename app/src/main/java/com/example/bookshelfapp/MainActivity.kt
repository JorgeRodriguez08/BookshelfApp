package com.example.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfapp.ui.theme.BookshelfAppTheme
import com.example.bookshelfapp.viewmodel.BooksViewModel.Companion.factory


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
        val booksViewModel: ViewModel = viewModel(factory = factory)


        Books(books = "", modifier = Modifier.padding(innerPadding))
    }
}



@Composable
fun Books(books: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $books\n",
        modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    BookshelfAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Books(books = "Android")
        }

    }
}