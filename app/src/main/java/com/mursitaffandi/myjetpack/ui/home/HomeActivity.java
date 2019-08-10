package com.mursitaffandi.myjetpack.ui.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.ui.favorite.FavoritesFragment;
import com.mursitaffandi.myjetpack.ui.listmovie.MovieListFragment;
import com.mursitaffandi.myjetpack.ui.listtvshow.TvShowListFragment;

public class HomeActivity extends AppCompatActivity {
    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.action_movie) {
            fragment = MovieListFragment.newInstance();
        } else if (item.getItemId() == R.id.action_tvshow) {
            fragment = TvShowListFragment.newInstance();
        } else if (item.getItemId() == R.id.action_favorite) {
            fragment = FavoritesFragment.newInstance();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit();
        }
        return true;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navView.setSelectedItemId(R.id.action_favorite);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
    }
}
