package com.fitnessch19.flatstomachworkout.utils;

import android.os.Build.VERSION;
import android.view.View;

import androidx.viewpager.widget.ViewPager.PageTransformer;

public class DepthPageTransformer implements PageTransformer {
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.8f;

    public void transformPage(View view, float f) {
        if (f < -1.0f) {
            f = -1.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        float f2 = ((f < 0.0f ? f + 1.0f : 1.0f - f) * 0.19999999f) + 0.8f;
        view.setScaleX(f2);
        view.setScaleY(f2);
        if (VERSION.SDK_INT < 19) {
            view.getParent().requestLayout();
        }
    }
}
