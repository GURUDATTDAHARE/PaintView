package com.gurudattdahare.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class PaintView extends View {
    private Paint paint;
    private Path path;
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

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawPath(path,paint);
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
}
