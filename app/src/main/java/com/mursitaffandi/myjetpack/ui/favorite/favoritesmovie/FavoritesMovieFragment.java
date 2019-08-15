package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.viewmodel.ViewModelFactory;

public class FavoritesMovieFragment extends Fragment {
    private FavoritesMoviePagedAdapter adapter;
    private RecyclerView rvFavorite;
    private ProgressBar progressBar;
    private FavoritesMovieViewModel viewModel;
    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            // Aksi di bawah digunakan untuk melakukan swap ke kenan dan ke kiri
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }
        
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }
        
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                // Sebelum melakukan penghapusan, movie harus mendapatkan posisi dari item yang di swipe
                int swipedPosition = viewHolder.getAdapterPosition();
                
                // Kemudian memanggil MovieEntity sesuai posisi ketika diswipe
                MovieEntity movieEntity = adapter.getItemById(swipedPosition);
                
                // Melakukan setFavorite untuk menghapus bookmark dari list movie
                viewModel.setBookmark(movieEntity);
                
                // Memanggil Snackbar untuk melakukan pengecekan, apakah benar melakukan penghapusan bookmark
                Snackbar snackbar = Snackbar.make(getView(), R.string.message_undo, Snackbar.LENGTH_LONG);
                
                // Mengembalikan item yang terhapus
                snackbar.setAction(R.string.message_ok, v -> viewModel.setBookmark(movieEntity));
                
                // Menampilkan snackbar
                snackbar.show();
            }
        }
    });
    
    public FavoritesMovieFragment() {
        // Required empty public constructor
    }
    
    public static Fragment newInstance() {
        return new FavoritesMovieFragment();
    }
    
    @NonNull
    private static FavoritesMovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoritesMovieViewModel.class);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_show, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavorite = view.findViewById(R.id.rv_list_show);
        progressBar = view.findViewById(R.id.progressbar_list_show);
    }
    
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = obtainViewModel(getActivity());
            
            adapter = new FavoritesMoviePagedAdapter(getActivity());
            
            viewModel.getBookmarksPaged().observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            adapter.submitList(movies.data);
                            adapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                
            });
            
            rvFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFavorite.setHasFixedSize(true);
            rvFavorite.setAdapter(adapter);
            
            //Memberikan aksi untuk swipe
            itemTouchHelper.attachToRecyclerView(rvFavorite);
        }
    }

}
