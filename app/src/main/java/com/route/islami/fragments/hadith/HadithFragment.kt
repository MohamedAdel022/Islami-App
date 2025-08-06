package com.route.islami.fragments.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.MultiBrowseCarouselStrategy
import com.route.islami.databinding.FragmentHadithBinding
import com.route.islami.fragments.hadith.adapter.HadithListAdapter
import com.route.islami.fragments.hadith.model.HadithDm

class HadithFragment : Fragment() {
    private lateinit var binding: FragmentHadithBinding
    private lateinit var adapter: HadithListAdapter
    private lateinit var carouselLayoutManger: CarouselLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HadithListAdapter(readHadithData())
        binding.hadithRecyclerView.adapter = adapter
        carouselLayoutManger =
            CarouselLayoutManager(MultiBrowseCarouselStrategy(), CarouselLayoutManager.HORIZONTAL)


        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.hadithRecyclerView)
        binding.hadithRecyclerView.setItemViewCacheSize(10)

    }

    fun readHadithData(): List<HadithDm> {
        val content =
            requireActivity().assets.open("hadith/ahadeth.txt").bufferedReader().use { reader ->
                reader.readText()
            }
        val hadithList = mutableListOf<HadithDm>()
        val list = content.trim().split("#")
        for (item in list) {
            val curHadithList = item.split("\n").filter { it.isNotBlank() }
            if (curHadithList.isNotEmpty() && curHadithList.size > 1) {
                val title = curHadithList[0].trim()
                val content = curHadithList.drop(1).joinToString("\n").trim()
                hadithList.add(HadithDm(title, content))
            }
        }
        return hadithList
    }

}