package com.example.quotesapp.network

import android.util.Log
import com.example.quotesapp.data.QuotesModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    // fetch the Quotes from the API
    fun getRandomQuotes(callback: (List<QuotesModel>?) -> Unit) {

        // Create Retrofit instance


        // Make an API call to get random quotes
        /*try {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.api-ninjas.com")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Create ApiService interface
            val api = retrofit.create(QuoteApiService::class.java)

            api.getQuotes("NDhab82nZgCk7YhEdw3dgA==DIEZHU5eKbNlquC3")
                .enqueue(object : Callback<ResponseBody> {
                    // Callback method on successful API response
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {

                        if (response.isSuccessful) {
                            val responseBody = response.body()
                            val jsonResponse = responseBody?.string()

                            //val jsonObject = JSONObject(jsonResponse)
                            *//*val quote = jsonObject.optString("quote")
                            val author = jsonObject.optString("author")*//*

                            Log.d("check", "response success: $jsonResponse")

                        } else {
                            callback(null)
                        }
                    }

                    // Callback method on API call failure
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        // Handle network failures or other errors
                    }
                })
        } catch (e: Exception) {
            Log.d("check", "the error: ${e.message.toString()}")
        }*/
    }
}


/*
fun parseQuoteJsonResult(jsonResult: JSONObject): QuotesModel {

    val objJson = jsonResult.getJSONObject("quote")
    val quote = objJson.getString("quote")
    val author = objJson.getString("author")
    val category = objJson.getString("category")

    return  QuotesModel(
        quote,
        author,
        category
    )

}*/
