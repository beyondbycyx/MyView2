package com.example.hq.drawabledemo;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by hq on 2015/5/15.
 */
//圆角image
/**
 * 步骤：
 * 1.传进一张bitmap图片
 * 2.将bitmap传进BitmapShader
 * 3.将BitmapShader传进paint画笔(还要消除锯齿)
 * 4.绘制drawable的width，height(即getIntrinsicwidth，getIntrinsicheight)
 * 5.在drawable的draw方法里绘制形状，如canvas.drawRoundRect矩形或canvas.drawCircle圆形
 * */
public class RoundImageDrawable extends Drawable
{
    //画笔
    private Paint mPaint;
    //位图
    private Bitmap mBitmap;
    //持有矩形的四个float型坐标，left,top,right,bottom
    private RectF rectF;

    public RoundImageDrawable(Bitmap bitmap)
    {
        mBitmap = bitmap;
        //该bitmapShader其实已经包含了传进来的bitmap,并为它添加了一个阴影图层
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
        //消除锯齿，使其图片平滑
        mPaint.setAntiAlias(true);
        //为画笔设置bitmap图片
        mPaint.setShader(bitmapShader);
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom)
    {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }

    @Override
    public void draw(Canvas canvas)
    {
        //180,180,分别设置它的x,y轴上的圆形半径（影响斜率）
        canvas.drawRoundRect(rectF, 180, 180, mPaint);
    }

    //为该drawable设置它的宽度，为bitmap图片的宽度
    @Override
    public int getIntrinsicWidth()
    {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight()
    {
        return mBitmap.getHeight();
    }

    @Override
    public void setAlpha(int alpha)
    {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf)
    {
        mPaint.setColorFilter(cf);
    }
    //获取不透明度
    @Override
    public int getOpacity()
    {
        return PixelFormat.TRANSLUCENT;
    }

}
