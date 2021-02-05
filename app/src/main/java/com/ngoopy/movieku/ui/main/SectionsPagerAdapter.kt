package com.ngoopy.movieku.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ngoopy.movieku.R
import com.ngoopy.movieku.ui.movie.MovieFragment
import com.ngoopy.movieku.ui.tv_show.TVShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getCount() = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TVShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
       mContext.resources.getString(TAB_TITLES[position])
}