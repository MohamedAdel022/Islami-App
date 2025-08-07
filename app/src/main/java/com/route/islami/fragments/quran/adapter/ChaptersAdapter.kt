package com.route.islami.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemQuranChapterBinding
import com.route.islami.fragments.quran.model.ChapterDM

class ChaptersAdapter(
    private val chapters: List<ChapterDM>,
    private val onItemClick: (ChapterDM) -> Unit
) :
    RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemQuranChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ChapterViewHolder,
        position: Int
    ) {
        val chapter = chapters[position]
        holder.bind(chapter)
        holder.binding.root.setOnClickListener {
            onItemClick(chapter)
        }
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    class ChapterViewHolder(val binding: ItemQuranChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChapterDM) {
            binding.chapterIndexTextView.text = item.index.toString()
            binding.chapterLengthTextView.text = "${item.length} Verses"
            binding.chapterNameEnglish.text = item.nameEnglish
            binding.chapterNameArabic.text = item.nameArabic


        }

    }
}