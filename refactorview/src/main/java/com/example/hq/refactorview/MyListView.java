package com.example.hq.refactorview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by hq on 2015/5/13.
 */
public class MyListView extends ListView implements View.OnTouchListener ,GestureDetector.OnGestureListener {

    //手势识别器,包含了OnGestureListener的接口
    private GestureDetector detector;
    public MyListView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        //将手势监听器this（里的覆盖方法即OnGestureListener接口）传给dector
        detector=new GestureDetector(getContext(),this);
        setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return detector.onTouchEvent(event);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
