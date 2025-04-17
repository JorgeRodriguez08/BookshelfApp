package com.example.bookshelfapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfapp.BooksApplication
import com.example.bookshelfapp.data.BooksRepository
import com.example.bookshelfapp.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class BooksViewModel(val jazzBooksRepository: BooksRepository): ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)

    init { searchBooks() }

    fun searchBooks() {
        viewModelScope.launch{
            booksUiState = BooksUiState.Loading
            booksUiState =
                try {
                    val books = jazzBooksRepository.getBooks()
                    books.toMutableList().forEach {
                        it.volumeInfo.imageLinks.thumbnail = it.volumeInfo.imageLinks.thumbnail.replace("http", "https")
                    }
                    BooksUiState.Success(books = books)
                }
                catch (e: IOException) { BooksUiState.Error }
                catch (e: HttpException) { BooksUiState.Error}
        }
    }

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val booksApplication = (this[APPLICATION_KEY] as BooksApplication)
                val jazzBooksRepository = booksApplication.container.jazzBooksRepository
                BooksViewModel(jazzBooksRepository = jazzBooksRepository)
            }
        }

    }
}