package com.example.quotesapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QuoteEntity")
data class QuoteDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "quote_text")
    val quote: String,
    @ColumnInfo(name = "quote_author")
    val author: String,
    @ColumnInfo(name = "quote_category")
    val category: String,
)