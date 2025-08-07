package com.route.islami.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islami.R
import com.route.islami.databinding.ActivityMainBinding
import com.route.islami.fragments.RadioFragment
import com.route.islami.fragments.TasbeehFragment
import com.route.islami.fragments.hadith.HadithFragment
import com.route.islami.fragments.quran.QuranFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    fun initViews() {
        binding.islamiBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.navigation_hadith -> {
                    pushFragment(HadithFragment())
                }

                R.id.navigation_tasbeeh -> {
                    pushFragment(TasbeehFragment())
                }

                R.id.navigation_radio -> {
                    pushFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        // Set the default selected item
        binding.islamiBottomNavigation.selectedItemId = R.id.navigation_quran
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}