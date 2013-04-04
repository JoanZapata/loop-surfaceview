package com.android.looper.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public final class DrawableUtil {

    private DrawableUtil() {
        // Prevent instanciation
    }

    /** Load a bitmap by its resId using the given context */
    public static Bitmap loadBitmap(Context context, int resId) {
        return ((BitmapDrawable) context.getResources()//
                .getDrawable(resId))//
                .getBitmap();
    }

}
