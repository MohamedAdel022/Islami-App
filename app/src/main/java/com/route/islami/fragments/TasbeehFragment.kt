package com.route.islami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentTasbeehBinding


class TasbeehFragment : Fragment() {
    private lateinit var binding: FragmentTasbeehBinding
    private var count: Int = 0
    private var currentTasbeehIndex: Int = 0
    private val tasbeehTexts = arrayOf("سبحان الله", "الحمد لله", "الله أكبر")
    private var tasbeehText: String = tasbeehTexts[0]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sebhahCount.text = count.toString()
        binding.sebhahText.text = tasbeehText
        setupListeners()
    }

    private fun setupListeners() {
        binding.sebhahBody.setOnClickListener {
            count++
            binding.sebhahCount.text = count.toString()
            if (count == 33) {

                currentTasbeehIndex = (currentTasbeehIndex + 1) % tasbeehTexts.size
                tasbeehText = tasbeehTexts[currentTasbeehIndex]
                binding.sebhahText.text = tasbeehText
                count = 0
                binding.sebhahCount.text = count.toString()
            }
        }
    }


}