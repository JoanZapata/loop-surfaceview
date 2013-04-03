package com.android.looper;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

/**
 * LoopSurfaceView is a final SurfaceView. You put it in your layout and use the
 * setAdapter(LoopSurfaceViewAdapter) method to override methods that is your
 * concern, like draw().
 * 
 * 
 * 
 * @author JoanZap
 * 
 */
public final class LoopSurfaceView extends SurfaceView {

    private static final String TAG = LoopSurfaceView.class.getSimpleName();

    private InnerThread innerThread;

    @SuppressWarnings("unused")
    private LoopAdapter adapter;

    public LoopSurfaceView(Context context) {
        super(context);
    }

    public LoopSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoopSurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /** Start the update/draw loop. */
    public void play() {

        // If the thread is running the surface view has been started before
        // and has never been stopped.
        if (innerThread != null && innerThread.isRunning()) {
            throw new IllegalStateException("You can't call play() twice.");
        }

        // Start the inner thread
        innerThread = new InnerThread();
        innerThread.start();

    }

    /** Pause the loop. You can start it again with play(). */
    public void pause() {
        // Stop the inner thread
        innerThread.cleanStop();
        innerThread = null;
    }

    /** Set the adapter for this surface view. */
    public void setAdapter(LoopAdapter adapter) {
        this.adapter = adapter;
    }

    private static class InnerThread extends Thread {

        private volatile boolean run = true;

        @Override
        public void run() {
            while (run) {
                try {
                    Thread.sleep(2000);
                    Log.i(TAG, "TEMP. Refresh.");
                } catch (InterruptedException e) {
                    Log.e(TAG, "Interrupted while sleeping.", e);
                }
            }
        }

        public boolean isRunning() {
            return run;
        }

        public void cleanStop() {
            run = false;
        }

    }

}
