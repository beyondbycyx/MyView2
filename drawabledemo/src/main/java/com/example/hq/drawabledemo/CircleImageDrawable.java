package com.example.hq.drawabledemo;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by hq on 2015/5/15.
 */
//圆形image
public class CircleImageDrawable extends Drawable
{

    private Paint mPaint;
    private int mWidth;
    private Bitmap mBitmap ;

    public CircleImageDrawable(Bitmap bitmap)
    {
        mBitmap = bitmap ;
        //该bitmapShader其实已经包含了传进来的bitmap,并为它添加了一个阴影图层
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
        //消除锯齿，使其图片平滑
        mPaint.setAntiAlias(true);
        //为画笔设置bitmap图片
        mPaint.setShader(bitmapShader);
        //以该图片上的长，宽中的最小的值作为圆形的半径
        mWidth = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
    }

    @Override
    public void draw(Canvas canvas)
    {
        //前两个为圆形的中心x,y的坐标，必须用构造方法中找到的长宽最小值中的作为x,y坐标
        //第三个参数(圆形半径)为以前面的x,y为原点，以该参数为半径画圆，该圆为切割作用，切割出该圆内的图像。
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth/2, mPaint);
    }
    //为该drawable设置它的宽度，为bitmap图片的中长，宽中的最小值
    @Override
    public int getIntrinsicWidth()
    {
        return mWidth;
    }

    @Override
    public int getIntrinsicHeight()
    {
        return mWidth;
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