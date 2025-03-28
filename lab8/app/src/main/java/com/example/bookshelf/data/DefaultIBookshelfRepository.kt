package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.IBookshelfApiService

/**
 * Default Implementation of repository that retrieves volumes data from underlying data source.
 */
class DefaultIBookshelfRepository(
    private val bookshelfApiService: IBookshelfApiService
) : IBookshelfRepository {
    override suspend fun getBooks(query: String): List<Book>? {
        return try {
            val res = bookshelfApiService.getBooks(query)
            if (res.isSuccessful) {
                res.body()?.items ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getBook(id: String): Book? {
        return try {
            val res = bookshelfApiService.getBook(id)
            if (res.isSuccessful) {
                res.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}