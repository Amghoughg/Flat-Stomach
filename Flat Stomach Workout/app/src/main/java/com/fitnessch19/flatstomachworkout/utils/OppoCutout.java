package com.fitnessch19.flatstomachworkout.utils;

import android.content.Context;
import android.graphics.Rect;

import androidx.annotation.NonNull;

public class OppoCutout implements ICutout {
    public Context context;

    public OppoCutout(@NonNull Context context2) {
        this.context = context2;
    }

    public Rect[] getCutout() {
        String[] split = System.getProperty("ro.oppo.screen.heteromorphism").split("[,:]");
        int[] iArr = new int[split.length];
        int i = 0;
        while (i < split.length) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
                i++;
            } catch (NumberFormatException unused) {
                iArr = null;
            }
        }
        if (iArr == null || iArr.length != 4) {
            return new Rect[0];
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = iArr[2];
        rect.bottom = iArr[3];
        return new Rect[]{rect};
    }

    public boolean hasCutout() {
        return this.context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
