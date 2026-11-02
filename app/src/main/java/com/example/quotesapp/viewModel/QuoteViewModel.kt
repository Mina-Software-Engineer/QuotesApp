package com.example.quotesapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.QuotesModel
import com.example.quotesapp.data.asQuoteModel
import com.example.quotesapp.repo.QuoteRepository
import com.example.quotesapp.room.QuoteDTO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class QuoteViewModel(app: Application, val repo: QuoteRepository) : AndroidViewModel(app) {
    private val _quotes = MutableLiveData<List<QuotesModel>?>()
    var quotes: LiveData<List<QuotesModel>?> = _quotes


    suspend fun getQuotes(category: String): List<QuotesModel> {
        return withContext(viewModelScope.coroutineContext) {
            _quotes.value = repo.getQuotes(category).asQuoteModel()
            //Log.d("check", "this is from viewModel: ${quotes.value!!}")
            quotes.value!!
        }
    }

    fun addNewQuoteToFav(quotesModel: QuotesModel) {
        viewModelScope.launch {
            repo.addNewQuote(
                QuoteDTO(
                    quote = quotesModel.quote,
                    author = quotesModel.author,
                    category = quotesModel.category
                )
            )
        }
    }
}