package com.example.bookshelf

enum class AppDestinations(val title: String) {
    MenuScreen(title = "Главное меню"),
    QueryScreen(title = "Google Bookshelf"),
    FavoriteScreen(title = "Избранное"),
    DetailScreen(title = "Книга: ")
}