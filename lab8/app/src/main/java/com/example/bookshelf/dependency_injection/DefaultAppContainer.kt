package com.example.bookshelf.dependency_injection

import com.example.bookshelf.data.IBookshelfRepository
import com.example.bookshelf.data.DefaultIBookshelfRepository
import com.example.bookshelf.network.IBookshelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**Default di-container implementation*/
class DefaultAppContainer : AppContainer {

    override val bookshelfApiService: IBookshelfApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(IBookshelfApiService.BASE_URL)
            .build()
            .create()
    }

    override val bookshelfRepository: IBookshelfRepository by lazy {
        DefaultIBookshelfRepository(bookshelfApiService)
    }
}