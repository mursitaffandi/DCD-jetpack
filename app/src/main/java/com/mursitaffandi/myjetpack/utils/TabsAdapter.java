package com.mursitaffandi.myjetpack.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.mursitaffandi.myjetpack.ui.showlist.ShowListFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public TabsAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.mNumOfTabs = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return ShowListFragment.newInstance(ShowListFragment.TYPE_MOVIE);

            case 1 :
                return ShowListFragment.newInstance(ShowListFragment.TYPE_TVSHOW);

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
