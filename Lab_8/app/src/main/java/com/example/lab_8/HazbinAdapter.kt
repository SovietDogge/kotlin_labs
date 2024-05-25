package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_8.databinding.HorizontalBinding


class HazbinAdapter (private val items: List<String>):
    RecyclerView.Adapter<HazbinAdapter.HazbinHandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HazbinHandler {
        val binding = HorizontalBinding.inflate(LayoutInflater.from(parent.context))
        return HazbinHandler(binding)
    }

    override fun onBindViewHolder(holder: HazbinHandler, position: Int) {
        val textName = items[position]
        holder.bind(textName)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Holds the views for adding it to image and text
    class HazbinHandler(private val binding: HorizontalBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(textName: String) {
            binding.textView.text = textName
        }
    }
}