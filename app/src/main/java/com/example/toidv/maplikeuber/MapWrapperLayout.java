package com.example.toidv.maplikeuber;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by TOIDV on 6/10/2016.
 */
public class MapWrapperLayout extends FrameLayout {
    private OnDragListener listener;


    public MapWrapperLayout(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (listener != null) {
            listener.onDrag(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setOnDragListener(OnDragListener listener) {
        this.listener = listener;
    }

    public interface OnDragListener {
        void onDrag(MotionEvent e);
    }
}
