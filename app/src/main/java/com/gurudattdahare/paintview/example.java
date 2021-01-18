package com.gurudattdahare.paintview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
public class example extends View {
    private Paint paint;
    private  Paint b_paint;
    private Path path;
    private float currntBrushsize=10f;
    private int currentColor=Color.BLACK;
    private Bitmap bitmap;
    private Canvas myCanvas;
    private int h,w;
    public example(Context context) {
        super(context);
        guru();
    }

    public example(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        guru();
    }
    public  void  guru(){
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        path=new Path();
        setBackgroundColor(Color.WHITE);
        b_paint=new Paint();
        b_paint.setColor(Color.BLACK);
        b_paint.setStrokeWidth(10f);
        b_paint.setStrokeJoin(Paint.Join.ROUND);
        b_paint.setStrokeCap(Paint.Cap.ROUND);
        b_paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0,h,w,h,b_paint);
          canvas.drawBitmap(bitmap,0,0,null);
        //super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                myCanvas.drawPath(path,paint);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                myCanvas.drawPath(path,paint);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                path.reset();
                break;
        }
        return true;
    }
    public void NewPaint(float size,int color){
        currentColor=color;
        paint.setColor(currentColor);
        paint.setStrokeWidth(size);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setXfermode(null);
        b_paint.setColor(currentColor);
    }
    public void red(){
        NewPaint(currntBrushsize,Color.RED);
    }
    public void blue(){
        NewPaint(currntBrushsize,Color.BLUE);
    }
    public  void  yellow(){
        NewPaint(currntBrushsize,Color.YELLOW);
    }
    public void green(){
        NewPaint(currntBrushsize,Color.GREEN);
    }
    public void black(){
        NewPaint(currntBrushsize,Color.BLACK);
    }
    public void eresor(){
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
    public void brushsize(Float size){
        currntBrushsize=size;
        NewPaint(currntBrushsize,currentColor);
    }
    public void clear(){
        path.reset();
        bitmap=Bitmap.createBitmap(getMeasuredWidth(),getMeasuredHeight(),Bitmap.Config.ARGB_8888);
        myCanvas=new Canvas(bitmap);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        myCanvas =new Canvas(bitmap);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        h=getMeasuredHeight();
        w=getMeasuredWidth();
    }
}
