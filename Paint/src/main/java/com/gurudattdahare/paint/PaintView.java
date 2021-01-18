package com.gurudattdahare.paint;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class PaintView extends ViewGroup {
    private SeekBar seekBar;
    private DrawingView drawingView;
    private Boolean visibleORnot=false;
    private SeekBar.OnSeekBarChangeListener listener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            drawingView.brushsize(Float.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    public PaintView(Context context) {
        super(context);
        guru(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        guru(context);
    }
    public void guru(Context context){
        drawingView =new DrawingView(context);
        addView(drawingView);
        LayoutInflater.from(getContext()).inflate(R.layout.my_seekbaar_layout,this);
        seekBar=findViewById(R.id.my_seekBar);
        seekBar.setOnSeekBarChangeListener(listener);
        seekBar.setVisibility(INVISIBLE);
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
                    //  example=findViewById(child.getId());

                }else if(i==1)
                {
                    seekBar.measure(MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST),MeasureSpec.makeMeasureSpec(100,MeasureSpec.AT_MOST));
                    seekBar.layout(0,30,width,30+100);
                }
                else {
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
    public void Red()
    {
        drawingView.red();
    }
    public void Blue(){
        drawingView.blue();
    }
    public void Yellow(){
        drawingView.yellow();
    }
    public void Ereser(){
        drawingView.ereser();

    }
    public void BrushSize(){
        if (!visibleORnot) {
            seekBar.setVisibility(VISIBLE);
            visibleORnot=true;
        }else {
            seekBar.setVisibility(INVISIBLE);
            visibleORnot=false;
        }
    }
    public void Black(){
        drawingView.black();
    }
    public void Green(){
        drawingView.green();
    }
    public void ClearScreen(){
        drawingView.clear();
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
