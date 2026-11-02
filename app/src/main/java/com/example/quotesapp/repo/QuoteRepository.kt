package com.example.quotesapp.repo

import com.example.quotesapp.room.QuoteDTO
import com.example.quotesapp.room.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao): QuoteDataSource{
    override suspend fun getQuotes(category: String): List<QuoteDTO> {
        return quoteDao.getAllQuotes(category)
    }

    override suspend fun addNewQuote(quote: QuoteDTO) {
        quoteDao.addNewQuote(quote)
    }

}