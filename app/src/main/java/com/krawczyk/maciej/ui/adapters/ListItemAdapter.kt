package com.krawczyk.maciej.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krawczyk.maciej.databinding.ResultRowItemBinding
import com.krawczyk.maciej.searchUseCase.models.SearchDataItem
import com.squareup.picasso.Picasso

class ListItemAdapter(
    private val onItemClickListener: (SearchDataItem) -> Unit
) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<SearchDataItem>()
    private lateinit var listItemAdapterListener: ListItemAdapterListener
    private lateinit var binding: ResultRowItemBinding

    class ViewHolder(
        private val binding: ResultRowItemBinding,
        private val listItemAdapterListener: ListItemAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(searchDataItem: SearchDataItem) {
            Picasso.get()
                .load(searchDataItem.previewURL)
                .into(binding.ivThumbnail)
            binding.let {
                it.searchData = searchDataItem
                it.listItemAdapterListener = listItemAdapterListener
            }
        }
    }

    fun updateAdapter(searchDataItems: List<SearchDataItem>) {
        dataSet.apply {
            clear()
            addAll(searchDataItems)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        listItemAdapterListener = ListItemAdapterListener {
            onItemClickListener.invoke(it)
        }
        binding = ResultRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listItemAdapterListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val largeNews = dataSet[position]
        holder.bind(largeNews)
    }

    override fun getItemCount() = dataSet.size
}