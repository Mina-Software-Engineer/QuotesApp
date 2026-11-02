package com.example.quotesapp.data

import com.example.quotesapp.room.QuoteDTO

data class QuotesModel(
    var quote: String,
    var author: String,
    var category: String
)

fun List<QuoteDTO>.asQuoteModel(): List<QuotesModel> {
    return map { quoteModel ->
        QuotesModel(
            quote = quoteModel.quote,
            author = quoteModel.author,
            category = quoteModel.category
        )
    }
}