package com.route.islami.activities.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemVerseBinding

class VersesAdapter(private val verses: List<String>) :
    RecyclerView.Adapter<VersesAdapter.VersesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VersesViewHolder {
        val context = parent.context
        val inflater = android.view.LayoutInflater.from(context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VersesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: VersesViewHolder,
        position: Int
    ) {
        val item = verses[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    class VersesViewHolder(val binding: ItemVerseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, position: Int) {
            binding.verseText.text = "$item [${position + 1}]"
        }

    }
}