package com.example.quotesapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.quotesapp.adapter.ViewPagerAdapter
import com.example.quotesapp.databinding.FragmentFavQuotesBinding
import com.example.quotesapp.viewModel.QuoteViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class FavQuotesFragment : Fragment() {


    private var _binding: FragmentFavQuotesBinding? = null
    private val binding get() = _binding

    val _viewModel: QuoteViewModel by inject()

    private lateinit var quoteAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavQuotesBinding.inflate(inflater)

        GlobalScope.launch {
            _viewModel.getQuotes("happiness")
        }

        //quoteAdapter = ViewPagerAdapter(emptyList())



        _viewModel.quotes.observe(viewLifecycleOwner, Observer { quoteList ->
            quoteAdapter = ViewPagerAdapter(quoteList ?: emptyList())

            binding!!.quoteViewPager.apply {
                adapter = quoteAdapter
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
            }
            Log.d("check", "this is from observer: $quoteList")
        })


        return binding!!.root
    }
}