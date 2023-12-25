package com.example.apiapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapplication.CatViewModel
import com.example.apiapplication.data.datamodels.CatFact
import com.example.apiapplication.databinding.ListItemBinding

class ItemAdapter()
: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private var dataset = listOf<CatFact>()
    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<CatFact>) {
        dataset = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var fact = dataset[position]
        holder.binding.itemTV.text = fact.text
    }
}