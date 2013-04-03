package com.android.looper;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * 
 * All object that is to be drawn (except the background) needs to implement
 * DrawableObject.
 * 
 * @author jzapata
 * 
 */
public interface DrawableObject {

	/**
	 * Draw itself on the given canvas.
	 * 
	 * @return the list of bounds in which it drawn something. The smaller the
	 *         area of these bounds is, the faster your application will be.
	 */
	Rect[] draw(Canvas canvas);

}
