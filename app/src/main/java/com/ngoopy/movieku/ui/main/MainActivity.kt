package com.ngoopy.movieku.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngoopy.movieku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.vpMain.adapter = sectionsPagerAdapter
        binding.tabsMain.setupWithViewPager(binding.vpMain)

        supportActionBar?.elevation = 0f

    }
}