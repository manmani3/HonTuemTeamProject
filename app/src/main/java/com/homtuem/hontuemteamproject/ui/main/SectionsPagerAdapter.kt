package com.homtuem.hontuemteamproject.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.homtuem.hontuemteamproject.R
import com.homtuem.hontuemteamproject.ui.main.fragment.AddScoreFragment
import com.homtuem.hontuemteamproject.ui.main.fragment.CurrentScoreFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_add,
    R.string.tab_status
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        when(position + 1) {
            1 -> return AddScoreFragment.newInstance()
            2 -> return CurrentScoreFragment.newInstance()
        }
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return TAB_TITLES.size
    }
}