package com.gurudattdahare.paint;

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
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Stack;

public class DrawingView extends View {
    private Paint paint;
    private  Paint b_paint;
    private Path path;
    private float currntBrushsize=10f;

    private int currentColor=Color.BLACK;
    private Bitmap mainbitmap;//current bitmap
    private Canvas myCanvas;
    private int h,w;
//  undo and redo implementation
    private Stack<Bitmap> stack1 =new Stack<>();//undo
    private Stack<Bitmap>stack2=new Stack<>();//redo
    private Boolean clearFlag=false;
    public DrawingView(Context context) {
        super(context);
        guru();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
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
        canvas.drawBitmap(mainbitmap,0,0,null);
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
                //        when bitmap is updated then we need to clear (pop) stack2(redo stack)
                while(!stack2.empty()){
                    stack2.pop();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                myCanvas.drawPath(path,paint);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                path.reset();
                //  main bitmap ka copy banayenge or stack1 me push karenge  kyoki  mainbitmap stack1 ke top ko represent karta hai
                //     jab hum mainbitmap ka copy nahi karte  or  mainbitmap me kuch or draw karte hai  to stack1 ka top bhi change ho jata hai fir use stack1 me push karne se
                //     stack1.top()-1 and stack1.top()  dono same ho jata hai
                //
                Bitmap bitmap1= mainbitmap.copy(mainbitmap.getConfig(),true);
                //      jab clear button click hoga tab ak empty bitmap stack1 ke top me aayega agar hum ab kuch draw karenge to ye empty bitmap stack1 me store ho jayega
                //        or fir jab hum undo karenge to vo empty bitmap screen isi liye jab clear button click hoga to stack1 ke top ki empty bitmap ko pop() karna importent hai.
                if(clearFlag==true){
                    stack1.pop();
                }
                stack1.push(bitmap1);
                resetClearflag();
                invalidate();
                break;
        }
        return true;
    }

    private void resetClearflag() {
        clearFlag=false;
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
        resetClearflag();
    }
    public void blue(){
        NewPaint(currntBrushsize,Color.BLUE);
        resetClearflag();
    }
    public  void  yellow(){
        NewPaint(currntBrushsize,Color.YELLOW);
        resetClearflag();
    }
    public void green(){
        NewPaint(currntBrushsize,Color.GREEN);
        resetClearflag();
    }
    public void black(){
        NewPaint(currntBrushsize,Color.BLACK);
        resetClearflag();
    }
    public void brown(){
        NewPaint(currntBrushsize,Color.rgb(210,105,30));
        resetClearflag();
    }
    public void colorPicker(int color){
        NewPaint(currntBrushsize,color);
        resetClearflag();
    }
    public void ereser(){
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        resetClearflag();
    }
    public void brushsize(Float size){
        currntBrushsize=size;
        NewPaint(currntBrushsize,currentColor);
        resetClearflag();
    }
    public void clear(){
        if(!clearFlag) {
            path.reset();
            Bitmap bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            mainbitmap = bitmap;
            stack1.push(bitmap);
            myCanvas = new Canvas(mainbitmap);
            while (!stack2.empty()) {
                stack2.pop();
            }
            invalidate();
            clearFlag=true;
        }
    }
    public void undo(){
        if (!stack1.empty()){
            //         jab clear button click hoga to empty bitmap top me hoga
            //         jab undo click hoga to stack1 ke top bitmap ko stack2 me push nahi karenge
            if(!clearFlag) {
                stack2.push(stack1.peek());
            }
            stack1.pop();
            if(!stack1.empty()) {
                //            agar top bitmap ka copy nahi karenge to mainbitmap change hone se stack1 ka top bhi change ho jayega
                Bitmap bitmap = stack1.peek().copy(stack1.peek().getConfig(),true);
                mainbitmap=bitmap;
                myCanvas=new Canvas(mainbitmap);
            }
            else
            {
                mainbitmap=Bitmap.createBitmap(getMeasuredWidth(),getMeasuredHeight(),Bitmap.Config.ARGB_8888);
                myCanvas=new Canvas(mainbitmap);
            }
            invalidate();
        }
        resetClearflag();

    }
    public void redo(){
        if(stack2.empty()){
            Toast.makeText(getContext(), "No Data..", Toast.LENGTH_SHORT).show();
        }else{
            stack1.push(stack2.peek());
            Bitmap bitmap =stack2.peek().copy(stack1.peek().getConfig(),true);
            mainbitmap=bitmap;
            myCanvas=new Canvas(mainbitmap);
            stack2.pop();
            invalidate();
        }
        resetClearflag();
    }
    public Bitmap getMainbitmap(){
        return mainbitmap;
    }
    public int getCurrentColor() {
        return currentColor;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mainbitmap =Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        myCanvas =new Canvas(mainbitmap);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        h=getMeasuredHeight();
        w=getMeasuredWidth();
    }
}
