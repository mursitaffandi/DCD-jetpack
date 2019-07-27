package com.mursitaffandi.myjetpack.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.mursitaffandi.myjetpack.ui.movie.MovieListFragment;
import com.mursitaffandi.myjetpack.ui.tvshow.TvShowListFragment;

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
                return MovieListFragment.newInstance();

            case 1 :
                return TvShowListFragment.newInstance();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
