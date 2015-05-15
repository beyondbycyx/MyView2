# MyView2
自定义view之组合View控件和继承View控件
自定义Drawable：
 * 步骤：
 * 1.传进一张bitmap图片
 * 2.将bitmap传进BitmapShader
 * 3.将BitmapShader传进paint画笔(还要消除锯齿)
 * 4.绘制drawable的width，height(即getIntrinsicwidth，getIntrinsicheight)
 * 5.在drawable的draw方法里绘制形状，如canvas.drawRoundRect矩形或canvas.drawCircle圆形
 * */
