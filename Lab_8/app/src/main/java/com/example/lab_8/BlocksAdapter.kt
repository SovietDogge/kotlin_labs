package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.VerticalBinding


class BlocksAdapter (private val items: List<Pair<String, String?>>,
                     private val onItemClick: (position: Int) -> Unit):
                    RecyclerView.Adapter<BlocksAdapter.BricksHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BricksHolder {
        val binding = VerticalBinding.inflate(LayoutInflater.from(parent.context))
        return BricksHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: BricksHolder, position: Int) {
        val brickName = items[position]
        holder.bind(brickName.first, brickName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Holds the views for adding it to image and text
    class BricksHolder(private val binding: VerticalBinding,
                       private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.buttonBrick.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }

            fun bind(brickName: String, imageUrl: String?) {
                Glide.with(binding.brickView)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(binding.brickView.drawable)
                    .error(R.drawable.ic_launcher_background)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(binding.brickView)
                binding.buttonBrick.text = brickName
        }
    }
}