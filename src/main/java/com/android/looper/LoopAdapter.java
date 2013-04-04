package com.android.looper;

import java.util.List;

import android.graphics.Canvas;

public interface LoopAdapter {

    void update(long elapsedTime);
    
    List<DrawableObject> getDrawableObjects();
    
    void drawBackground(Canvas canvas);

}
