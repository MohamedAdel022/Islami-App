package com.route.islami.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.activities.adapters.VersesAdapter
import com.route.islami.databinding.ActivityQuranVersesBinding
import com.route.islami.fragments.quran.utils.ChapterKeys

class QuranVersesActivity : AppCompatActivity() {
    private var ChapterNameEnglish: String? = null
    private var ChapterNameArabic: String? = null
    private var ChapterNumber: Int = 0
    private var chapterLength: Int = 0
    private lateinit var binding: ActivityQuranVersesBinding

    private lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuranVersesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initArgs()
        initViews()
    }

    fun initArgs() {
        ChapterNameEnglish = intent.getStringExtra(ChapterKeys.chapterNameEnglish)
        ChapterNameArabic = intent.getStringExtra(ChapterKeys.chapterNameArabic)
        ChapterNumber = intent.getIntExtra(ChapterKeys.chapterNumber, 0)
        chapterLength = intent.getIntExtra(ChapterKeys.chapterLength, 0)
    }

    fun initViews() {
        binding.toolbarTitleEnglish.text = ChapterNameEnglish
        binding.verseTitleArabic.text = ChapterNameArabic
        binding.toolbarBackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val list = readChapterContent()
        adapter = VersesAdapter(list)
        binding.versesRecyclerView.adapter = adapter


    }

    fun readChapterContent(): List<String> {
        return assets.open("quran/${ChapterNumber}.txt").bufferedReader().use { reader ->
            reader.readLines().filter {
                it.isNotEmpty() && it.isNotBlank()
            }
        }
    }
}