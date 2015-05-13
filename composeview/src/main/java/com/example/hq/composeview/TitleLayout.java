package com.example.hq.composeview;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hq on 2015/5/13.
 */
public class TitleLayout extends FrameLayout {

    //组合View控件
    private View mView;
    //子view
    private ImageView leftbt;
    private ImageView rightbt;
    private TextView textView;


    public TitleLayout(final Context context,AttributeSet attrs)
    {
        super(context, attrs);

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        //注意：必须为R.layout.compose_title的视图添加this（FramLayout）作为根视图
        mView=layoutInflater.inflate(R.layout.compose_title,this);

        leftbt=(ImageView)mView.findViewById(R.id.title_left_bt);
        rightbt=(ImageView)mView.findViewById(R.id.title_right_bt);
        textView=(TextView)mView.findViewById(R.id.title_center_tv);

        leftbt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();

            }
        });
    }
    public void setLeftbtResource(int resId)
    {
        if(leftbt!=null)
        leftbt.setImageResource(resId);
    }
    public void setRightbtResource(int resId)
    {
        rightbt.setImageResource(resId);
    }
    public void setCenterTextViewText(String text)
    {
        textView.setText(text);
    }
}
