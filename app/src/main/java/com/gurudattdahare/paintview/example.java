package com.gurudattdahare.paintview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class example extends View {

    private Paint paint;
    private Path path;
    private float currntBrushsize=10f;
    private List<modal> list=new ArrayList<>();
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
      AddList();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        modal modal;
        for (int i=0;i<list.size();i++){
             modal=list.get(i);
            canvas.drawPath(modal.getPath(),modal.getPaint());
        }

        //super.onDraw(canvas);
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
    public void NewPaint(float size,int color){
        paint=new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(size);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        path=new Path();
        AddList();
    }
    public void AddList(){
        modal modal=new modal(paint,path);
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
    public void eresor(){

        path=new Path();
        NewPaint(currntBrushsize,Color.WHITE);
        AddList();
    }
    public void brushsize(){

    }
    public void clear(){
        list.clear();
        invalidate();
    }

}
