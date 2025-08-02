package com.route.islami

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islami.databinding.ActivityMainBinding
import com.route.islami.fragments.HadithFragment
import com.route.islami.fragments.QuranFragment
import com.route.islami.fragments.RadioFragment
import com.route.islami.fragments.TasbeehFragment

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
               R.id.navigation_quran ->{
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
    }

    fun pushFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}