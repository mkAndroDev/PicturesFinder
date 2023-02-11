package com.krawczyk.maciej.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krawczyk.maciej.databinding.ResultRowItemBinding
import com.krawczyk.maciej.models.Hits

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<Hits>()
    private lateinit var binding: ResultRowItemBinding

    class ViewHolder(
        private val binding: ResultRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hits: Hits) {
            binding.hits = hits
        }
    }

    fun updateAdapter(hits: List<Hits>) {
        dataSet.apply {
            clear()
            addAll(hits)
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