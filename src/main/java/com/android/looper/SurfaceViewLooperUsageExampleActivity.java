package com.android.looper;

import java.util.List;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;

public class SurfaceViewLooperUsageExampleActivity extends Activity implements LoopSurfaceViewAdapter {

    private LoopSurfaceView loopSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loopSurfaceView = (LoopSurfaceView) findViewById(R.id.sample);
        loopSurfaceView.setAdapter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loopSurfaceView.play();
    }

    @Override
    protected void onPause() {
        super.onPause();
        loopSurfaceView.pause();
    }

    @Override
    public List<DrawableObject> getDrawableObjects() {
        return null;
    }

    @Override
    public void drawBackground(Canvas canvas, Rect bounds) {
        
    }

}
