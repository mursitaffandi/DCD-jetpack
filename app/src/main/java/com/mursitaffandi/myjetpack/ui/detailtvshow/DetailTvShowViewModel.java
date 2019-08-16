package com.mursitaffandi.myjetpack.ui.detailtvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

public class DetailTvShowViewModel extends ViewModel {
    private ShowRepository movieRepository;
    
    public DetailTvShowViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    private final MutableLiveData<Integer> tvshowId = new MutableLiveData<>();
    public final LiveData<Resource<TvshowEntity>> tvshowItem =
            Transformations.switchMap(tvshowId,
                    mCourseId -> movieRepository.getTvShow(tvshowId.getValue()));
    
    public Integer getTvshowId() {
        if (tvshowId.getValue() == null) return null;
        return tvshowId.getValue();
    }
    
    public void setTvshowId(Integer tvshowId) {
        this.tvshowId.setValue(tvshowId);
    }
    
    void setBookmark() {
        if (tvshowItem.getValue() != null) {
            TvshowEntity tvshowItemForbookmark = this.tvshowItem.getValue().data;
            
            if (tvshowItemForbookmark != null) {
                
                // Kode di bawah menggunakan tanda seru (!),
                // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
                final boolean newState = !tvshowItemForbookmark.isBookmarked();
                movieRepository.setTvshowBookmark(tvshowItemForbookmark, newState);
            }
        }
    }
}
