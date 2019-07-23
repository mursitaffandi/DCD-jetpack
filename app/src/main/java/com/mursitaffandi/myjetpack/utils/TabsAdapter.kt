package com.mursitaffandi.myjetpack.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mursitaffandi.myjetpack.ui.showlist.ShowListFragment

class TabsAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return mNumOfTabs
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return ShowListFragment()
            }
            1 -> {
                return ShowListFragment()
            }
            else -> return null
        }
    }
}
