package com.route.islami.fragments.hadith.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemHadithBinding
import com.route.islami.fragments.hadith.model.HadithDm


class HadithListAdapter(private val hadithList: List<HadithDm>) :
    RecyclerView.Adapter<HadithListAdapter.HadithViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadithViewHolder {
        val context = parent.context
        val inflater = android.view.LayoutInflater.from(context)
        val binding = ItemHadithBinding.inflate(inflater, parent, false)
        return HadithViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HadithViewHolder,
        position: Int
    ) {
        val item = hadithList[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return hadithList.size
    }

    class HadithViewHolder(val binding: ItemHadithBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HadithDm) {
            binding.hadithTitleTextView.text = item.title
            binding.hadithDescriptionTextView.text = item.content

        }

    }
}