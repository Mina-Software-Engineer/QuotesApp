package com.example.quotesapp.repo

import com.example.quotesapp.room.QuoteDTO

interface QuoteDataSource {
    suspend fun getQuotes(category: String): List<QuoteDTO>
    suspend fun addNewQuote(quote: QuoteDTO)
}