package com.krawczyk.maciej.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krawczyk.maciej.databinding.ResultRowItemBinding
import com.krawczyk.maciej.searchUseCase.models.SearchDataItem
import com.squareup.picasso.Picasso

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<SearchDataItem>()
    private lateinit var binding: ResultRowItemBinding

    class ViewHolder(
        private val binding: ResultRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(searchDataItem: SearchDataItem) {
            Picasso.get()
                .load(searchDataItem.previewURL)
                .into(binding.ivThumbnail)
            binding.searchData = searchDataItem
        }
    }

    fun updateAdapter(searchDataItems: List<SearchDataItem>) {
        dataSet.apply {
            clear()
            addAll(searchDataItems)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ResultRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val largeNews = dataSet[position]
        holder.bind(largeNews)
    }

    override fun getItemCount() = dataSet.size

}