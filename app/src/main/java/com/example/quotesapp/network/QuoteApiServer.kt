package com.example.quotesapp.network


import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.api-ninjas.com")
    .client(OkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface QuoteApiService {
    @GET("v1/quotes?category=happiness")
    fun getQuotes(@Header("X-Api-Key") apiKey: String): Call<ResponseBody>
}

object QuotesApi {
    val retrofitService: QuoteApiService by lazy { retrofit.create(QuoteApiService::class.java) }
}
