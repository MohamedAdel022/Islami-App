package com.route.islami.fragments.quran.model

import java.io.Serializable

data class ChapterDM(
    val index: Int,
    val nameEnglish: String,
    val nameArabic: String,
    val length: Int
) : Serializable


