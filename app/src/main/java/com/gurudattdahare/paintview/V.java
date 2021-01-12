package com.gurudattdahare.paintview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import com.gurudattdahare.paint.PaintView;

public class V extends ViewGroup {
    private SeekBar seekBar;
    private SeekBar.OnSeekBarChangeListener listener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            example.brushsize(Float.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private example example;
    public V(Context context) {
        super(context);
       // LayoutInflater.from(context).inflate(R.layout.test,this);
    }

    public V(Context context, AttributeSet attrs) {
        super(context, attrs);
      //  LayoutInflater.from(context).inflate(R.layout.test,this);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count=getChildCount();
        Log.d("guru","count "+count);
        int leftPadding=getPaddingLeft();
        int rightPadding=getPaddingRight();
        int topPadding=getPaddingTop();
        int bottomPadding=getPaddingBottom();

        int hight= getMeasuredHeight()-(topPadding+bottomPadding);
        int width= getMeasuredWidth()-(leftPadding+rightPadding);

        int startX=leftPadding;
        int startY=topPadding;

        for(int i=0;i<count;i++){
            View child=getChildAt(i);
            if(child.getVisibility()!=GONE){
                if(i==0){
                    child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST),
                            MeasureSpec.makeMeasureSpec(hight* 11 / 12, MeasureSpec.AT_MOST));
                    int childhight=child.getMeasuredHeight();
                    int childwidth=child.getMeasuredWidth();
                    child.layout(startX,startY,leftPadding+childwidth,topPadding+childhight);
                    startX=startX+width/25;
                    startY=startY+childhight+hight/48;
                    example=findViewById(child.getId());

                }else {
                    if(i==count-1)
                    {
                        LayoutInflater.from(getContext()).inflate(R.layout.test,this);
                        seekBar=findViewById(R.id.seekBar);
                        seekBar.measure(MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST),MeasureSpec.makeMeasureSpec(100,MeasureSpec.AT_MOST));
                        seekBar.layout(0,30,width,30+100);
                        seekBar.setOnSeekBarChangeListener(listener);
                    }
                        child.measure(MeasureSpec.makeMeasureSpec(2 * width / 25, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(2 * hight / 48, MeasureSpec.AT_MOST));
                        int childhight = child.getMeasuredHeight();
                        int childwidth = child.getMeasuredWidth();
                        child.layout(startX, startY, startX + childwidth, startY + childhight);
                        startX = startX + 3 * width / 25;

                }
            }
        }
    }
}
