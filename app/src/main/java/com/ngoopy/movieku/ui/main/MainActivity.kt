package com.ngoopy.movieku.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ngoopy.movieku.R
import com.ngoopy.movieku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_FAVORITE = "extra_favorite"
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, intent.getBooleanExtra(EXTRA_FAVORITE, false))
        binding?.vpMain?.adapter = sectionsPagerAdapter
        binding?.tabsMain?.setupWithViewPager(binding?.vpMain)

        supportActionBar?.elevation = 0f
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (!intent.getBooleanExtra(EXTRA_FAVORITE, false)) {
            menuInflater.inflate(R.menu.main_menu, menu)
        } else {
            supportActionBar?.title = "Favorite"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_favorite) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EXTRA_FAVORITE, true)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}