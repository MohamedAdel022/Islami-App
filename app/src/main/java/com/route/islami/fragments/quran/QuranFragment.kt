package com.route.islami.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.activities.QuranVersesActivity
import com.route.islami.databinding.FragmentQuranBinding
import com.route.islami.fragments.quran.adapter.ChaptersAdapter
import com.route.islami.fragments.quran.utils.ChapterKeys
import com.route.islami.fragments.quran.utils.QuranUtils

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: ChaptersAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChaptersAdapter(QuranUtils.getChapters(), {
            val intent = Intent(context, QuranVersesActivity::class.java)
            intent.putExtra(ChapterKeys.chapterNumber, it.index)
            intent.putExtra(ChapterKeys.chapterNameArabic, it.nameArabic)
            intent.putExtra(ChapterKeys.chapterNameEnglish, it.nameEnglish)
            intent.putExtra(ChapterKeys.chapterLength, it.length)
            startActivity(intent)

        })
        binding.quranRecyclerView.adapter = adapter
    }

}