package com.mursitaffandi.myjetpack.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie.FavoritesMovieFragment;
import com.mursitaffandi.myjetpack.ui.favorite.favoritestvshow.FavoritesTvshowFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;

    public TabsAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.mNumOfTabs = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return FavoritesMovieFragment.newInstance();

            case 1 :
                return FavoritesTvshowFragment.newInstance();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
