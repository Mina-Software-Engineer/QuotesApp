package com.example.quotesapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quotesapp.data.QuotesModel
import com.example.quotesapp.databinding.FragmentHomeBinding
import com.example.quotesapp.network.QuotesApi
import com.example.quotesapp.viewModel.QuoteViewModel
import okhttp3.ResponseBody
import org.json.JSONArray
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private val _viewModel: QuoteViewModel by inject()

    private lateinit var quoteModel: QuotesModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        // Inflate the layout for this fragment

        // Make API call to get random quotes

        getQuote()

        binding!!.favBtn.setOnClickListener {
            _viewModel.addNewQuoteToFav(quoteModel)
            //Log.d("check", "this is from homeFragment: $quoteModel")
        }

        binding!!.myQuotesBtn.setOnClickListener {
            this.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToFavQuotesFragment())
        }

        return binding!!.root
    }


    private fun getQuote() {

        QuotesApi.retrofitService.getQuotes("NDhab82nZgCk7YhEdw3dgA==DIEZHU5eKbNlquC3")
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    try {

                        val responseBody = response.body()
                        val jsonResponse = responseBody?.string()

                        val jsonObject = JSONArray(jsonResponse).getJSONObject(0)
                        val quote = jsonObject.getString("quote")
                        val author = jsonObject.getString("author")
                        val category = jsonObject.getString("category")

                        quoteModel = QuotesModel(quote, author, category)

                        binding!!.tvQuote.text = quote
                        binding!!.tvAuthor.text = "~ " + author

                    } catch (e: Exception) {
                        Log.d("check", "response error: ${e.message.toString()}")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }
}