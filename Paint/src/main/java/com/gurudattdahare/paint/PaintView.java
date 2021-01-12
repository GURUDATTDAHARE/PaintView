package com.gurudattdahare.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PaintView extends View {
    private Paint paint;
    private Path path;
    private float currntBrushsize=10f;
    private int currentColor=Color.BLACK;
    private List<Modal> list=new ArrayList<>();
    private float h;
    private float w;
    public PaintView(Context context) {
        super(context);
        guru();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
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
        AddList();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0,h,w,h,paint);

        Modal modal;
        for (int i=0;i<list.size();i++){
            modal=list.get(i);
            canvas.drawPath(modal.getPath(),modal.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                break;
             case MotionEvent.ACTION_MOVE:
                 path.lineTo(x,y);
                 invalidate();
                 break;
        }
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        h=getMeasuredHeight();
        w=getMeasuredWidth();
    }

    public void NewPaint(float size,int color){
        currentColor=color;
        paint=new Paint();
        paint.setColor(currentColor);
        paint.setStrokeWidth(size);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);

        path=new Path();
        AddList();
    }
    public void AddList(){
        Modal modal=new Modal(paint,path);
        list.add(modal);
    }
    public void red(){

        path=new Path();
        NewPaint(currntBrushsize,Color.RED);
        AddList();
    }
    public void blue(){

        path=new Path();
        NewPaint(currntBrushsize,Color.BLUE);
        AddList();
    }
    public  void  yellow(){

        path=new Path();
        NewPaint(currntBrushsize,Color.YELLOW);
        AddList();
    }
    public void green(){

       path=new Path();
       NewPaint(currntBrushsize,Color.GREEN);
        AddList();
    }
    public void black(){

        path=new Path();
        NewPaint(currntBrushsize,Color.BLACK);
        AddList();
    }
    public void Brown(){
        path=new Path();
        NewPaint(currntBrushsize,Integer.valueOf(Color.parseColor("#964B00")));
        AddList();
    }
    public void eresor(){

        path=new Path();
        NewPaint(currntBrushsize,Color.WHITE);
        AddList();
    }
    public void brushsize(Float size){
        path =new Path();
        currntBrushsize=size;
        NewPaint(currntBrushsize,currentColor);
        AddList();

    }
    public void clear(){
        list.clear();
        invalidate();
    }
}
