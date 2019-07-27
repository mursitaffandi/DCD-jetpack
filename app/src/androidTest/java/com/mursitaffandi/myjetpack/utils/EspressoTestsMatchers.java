package com.mursitaffandi.myjetpack.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.Arrays;

public class EspressoTestsMatchers {

    public static Matcher<View> withDrawable(int drawableId) {
        return new BoundedMatcher<View, ImageView>(ImageView.class) {

            @Override public void describeTo(Description description) {
                description.appendText("has image with drawable ID: " + drawableId);
            }

            @Override protected boolean matchesSafely(ImageView view) {
                return assertDrawable(view.getDrawable(), drawableId, view);
            }
        };
    }

    private static boolean compareBitmaps(Bitmap img1, Bitmap img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            int[] img1Pixels = new int[img1.getWidth() * img1.getHeight()];
            int[] img2Pixels = new int[img2.getWidth() * img2.getHeight()];

            img1.getPixels(img1Pixels, 0, img1.getWidth(), 0, 0, img1.getWidth(), img1.getHeight());
            img2.getPixels(img2Pixels, 0, img2.getWidth(), 0, 0, img2.getWidth(), img2.getHeight());

            return Arrays.equals(img1Pixels, img2Pixels);
        }
        return false;
    }

    private static boolean assertDrawable(Drawable actual, int expectedId, View v) {
        if (!(actual instanceof BitmapDrawable)) {
            return false;
        }

        Bitmap expectedBitmap = null;
        try {
            expectedBitmap = BitmapFactory.decodeResource(v.getContext().getResources(), expectedId);

            return compareBitmaps(((BitmapDrawable) actual).getBitmap(), expectedBitmap);

        } catch (OutOfMemoryError error) {
            return false;

        } finally {
            if (expectedBitmap != null) {
                expectedBitmap.recycle();
            }
        }
    }

}
