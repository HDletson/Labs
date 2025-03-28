package com.example.bookshelf.dependency_injection

import com.example.bookshelf.data.IBookshelfRepository
import com.example.bookshelf.network.IBookshelfApiService

/**Application di-container*/
interface AppContainer {
    val bookshelfApiService: IBookshelfApiService
    val bookshelfRepository: IBookshelfRepository
}