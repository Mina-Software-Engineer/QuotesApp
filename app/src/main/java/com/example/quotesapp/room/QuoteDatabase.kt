package com.example.quotesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "quote_database"

@Database(entities = [QuoteDTO::class], version = 1, exportSchema = false)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(
            context: Context
        ): QuoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }


    }

}