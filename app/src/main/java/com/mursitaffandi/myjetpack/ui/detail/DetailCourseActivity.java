package com.mursitaffandi.myjetpack.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mursitaffandi.myjetpack.R;

public class DetailCourseActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW = "extra_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
    }
}
