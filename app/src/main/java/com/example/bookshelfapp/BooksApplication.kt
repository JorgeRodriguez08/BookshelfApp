package com.example.bookshelfapp

import android.app.Application
import com.example.bookshelfapp.data.AppContainer
import com.example.bookshelfapp.data.BooksAppContainer

class BooksApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = BooksAppContainer()
    }
}