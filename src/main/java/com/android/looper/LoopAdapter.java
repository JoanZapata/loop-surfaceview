package com.android.looper;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface LoopAdapter {

    List<DrawableObject> getDrawableObjects();
    
    void drawBackground(Canvas canvas, Rect bounds);

}
