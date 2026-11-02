package com.example.quotesapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.QuotesModel
import com.example.quotesapp.databinding.QuoteViewpagerItemBinding

class ViewPagerAdapter( val quoteList: List<QuotesModel>): RecyclerView.Adapter<ViewPagerAdapter.QuoteViewHolder>() {


    class QuoteViewHolder(val binding: QuoteViewpagerItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(quotesModel: QuotesModel) {
            if (!quotesModel.quote.isNullOrEmpty()){
                binding.favQuoteTv.text = quotesModel.quote
                Log.d("check", "this is from adapter: ${quotesModel.quote}")
            }
        }


        companion object {
            fun from(parent: ViewGroup): QuoteViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = QuoteViewpagerItemBinding.inflate(layoutInflater, parent, false)

                return QuoteViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder.from(parent)
    }

    override fun getItemCount() = quoteList.size


    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(quoteList[position])
    }
}