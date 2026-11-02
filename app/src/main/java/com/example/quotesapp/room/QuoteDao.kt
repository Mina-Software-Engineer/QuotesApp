package com.example.quotesapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM QuoteEntity WHERE quote_category = :category")
    suspend fun getAllQuotes(category: String): List<QuoteDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewQuote(quote: QuoteDTO)
}