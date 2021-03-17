package com.gurudattdahare.paint;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;

import com.gurudattdahare.paint.EventManneger.OnEventsListener;

public class PaintView extends ViewGroup implements View.OnClickListener {
    private SeekBar seekBar;
    private ImageView brushSizePreview;
    private DrawingView drawingView;
    private Boolean visibleORnot = false;
    int img_position_X, img_position_Y;
    // 0.0.8 version
    // ---------------->><<----------------
    private Button tool;
    private Boolean istoolOn=false;
    private Button red,blue,green,yellow,black,brown,eraser,brush,refresh,undo,redo,save,cancle;
    private PopupWindow popupWindow;
    private int popupX;
    private int popupY;
    private OnEventsListener onEventsListener;
    //---------------->><<<-----------------

    private final SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            drawingView.brushsize(Float.valueOf(progress));
            // change size of preview img
            brushSizePreview.measure(MeasureSpec.makeMeasureSpec(progress + 5, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(progress + 5, MeasureSpec.EXACTLY));
            brushSizePreview.requestLayout();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            brushSizePreview.setVisibility(View.VISIBLE);
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            brushSizePreview.setVisibility(View.GONE);
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

    public void guru(Context context) {
        drawingView = new DrawingView(context);
        addView(drawingView);
        LayoutInflater.from(getContext()).inflate(R.layout.my_seekbaar_layout, this);
        seekBar = findViewById(R.id.my_seekBar);
        seekBar.setOnSeekBarChangeListener(listener);
        seekBar.setVisibility(INVISIBLE);

        tool=findViewById(R.id.tool_button);
        tool.setOnClickListener(this);

        brushSizePreview = new ImageView(context);
        brushSizePreview.setImageResource(R.drawable.ic_preview);
        addView(brushSizePreview);
        brushSizePreview.setVisibility(View.GONE);

        initListenar();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int leftPadding = getPaddingLeft();
        int rightPadding = getPaddingRight();
        int topPadding = getPaddingTop();
        int bottomPadding = getPaddingBottom();

        int hight = getMeasuredHeight() - (topPadding + bottomPadding);
        int width = getMeasuredWidth() - (leftPadding + rightPadding);

        int startX = leftPadding;
        int startY = topPadding;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                if (i == 0) {
      //              i==0  -> drawing view  its higth=match parent and width= match parent
                    child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST),
                            MeasureSpec.makeMeasureSpec(hight, MeasureSpec.AT_MOST));
                    int childhight = child.getMeasuredHeight();
                    int childwidth = child.getMeasuredWidth();
                    child.layout(startX, startY, leftPadding + childwidth, topPadding + childhight);
                } else if (i == 1) {
      //                 seekbar width= match parent and hight =100dp
                    seekBar.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(100, MeasureSpec.AT_MOST));
                    seekBar.layout(0, 30, width, 30 + 100);
                } else if (i == 3) {
                    int childhight = child.getMeasuredHeight();
                    int childwidth = child.getMeasuredWidth();
                    img_position_X = width / 2 - childwidth / 2;
                    img_position_Y = hight / 2 - childhight / 2;
                    brushSizePreview.layout(img_position_X, img_position_Y, img_position_X + childwidth, img_position_Y + childhight);
                } else {
                    //                    Tool button  its width is langth of 5th part of width  and  hight is langth of 10th part of hight
                    child.measure(MeasureSpec.makeMeasureSpec( width / 5, MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec( hight / 10, MeasureSpec.AT_MOST));
                    int childhight = child.getMeasuredHeight();
                    int childwidth = child.getMeasuredWidth();
                    startX=width-childwidth-50;
                    startY=hight-childhight-50;
                    //popup version
                    child.layout(startX,startY,startX+childwidth,startY+childhight);

                }
            }
        }
    }

    private void Red() {
        drawingView.red();
    }

    private void Blue() {
        drawingView.blue();
    }

    private void Yellow() {
        drawingView.yellow();
    }
    private void Brown(){
        drawingView.brown();
    }

    private void Ereser() {
        drawingView.ereser();

    }

    private void BrushSize() {
        if (!visibleORnot) {
            seekBar.setVisibility(VISIBLE);
            visibleORnot = true;
        } else {
            seekBar.setVisibility(INVISIBLE);
            visibleORnot = false;
        }
    }

    private void Black() {
        drawingView.black();
    }

    private void Green() {
        drawingView.green();
    }

    private void ClearScreen() {
        drawingView.clear();
    }
    private void Undo(){
        drawingView.undo();
    }
    private void Redo(){
        drawingView.redo();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tool_button) {

            if(istoolOn==false) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.tools, null);
                red = view.findViewById(R.id.red_button);
                blue = view.findViewById(R.id.blue_button);
                green = view.findViewById(R.id.green_button);
                yellow = view.findViewById(R.id.yellow_button);
                black = view.findViewById(R.id.black_button);
                brown = view.findViewById(R.id.brown_button);
                undo = view.findViewById(R.id.undo_button);
                redo = view.findViewById(R.id.redo);
                save = view.findViewById(R.id.download_button);
                eraser = view.findViewById(R.id.eraser_button);
                brush = view.findViewById(R.id.brush_size_button);
                refresh = view.findViewById(R.id.refresh_button);
                cancle = view.findViewById(R.id.cancle_button);
                red.setOnClickListener(this);
                blue.setOnClickListener(this);
                green.setOnClickListener(this);
                yellow.setOnClickListener(this);
                black.setOnClickListener(this);
                brown.setOnClickListener(this);
                undo.setOnClickListener(this);
                redo.setOnClickListener(this);
                save.setOnClickListener(this);
                eraser.setOnClickListener(this);
                brush.setOnClickListener(this);
                refresh.setOnClickListener(this);
                cancle.setOnClickListener(this);
                popupWindow = new PopupWindow(view, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                popupX = 465;
                popupY = 1247;
                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, popupX, popupY);
                view.setOnTouchListener(new OnTouchListener() {
                    private float x, y;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = event.getAction();
                        if (action == MotionEvent.ACTION_DOWN) {
                            x = popupX - event.getRawX();
                            y = popupY - event.getRawY();
                        } else if (action == MotionEvent.ACTION_MOVE) {
                            popupX = (int) (x + event.getRawX());
                            popupY = (int) (y + event.getRawY());
                            popupWindow.update(popupX, popupY, -1, -1);

                        }
                        return true;
                    }
                });
            }

         istoolOn=true;
        } else if (id == R.id.red_button) {
            Red();
            onEventsListener.OnRedClicked();
        } else if (id == R.id.blue_button) {
            Blue();
            onEventsListener.OnBlueClicked();
        } else if (id == R.id.green_button) {
            Green();
            onEventsListener.OnGreenClicked();
        } else if (id == R.id.yellow_button) {
            Yellow();
            onEventsListener.OnYellowClicked();
        } else if (id == R.id.black_button) {
            Black();
            onEventsListener.OnBlackClicked();
        } else if (id == R.id.brown_button) {
             Brown();
            onEventsListener.OnBrownClicked();
        } else if (id == R.id.eraser_button) {
            Ereser();
            onEventsListener.OnEraserClicked();
        } else if (id == R.id.brush_size_button) {
            BrushSize();
            onEventsListener.OnBrushSizeClicked();
        } else if (id == R.id.refresh_button) {
            ClearScreen();
            onEventsListener.OnClearClicked();
        } else if (id == R.id.cancle_button) {
            popupWindow.dismiss();
            istoolOn=false;
        } else if (id == R.id.undo_button) {
            Undo();
           onEventsListener.OnUndoClicked();
        } else if (id == R.id.redo) {
            Redo();
            onEventsListener.OnRedoclicked();
        }else  if(id==R.id.download_button){
            Bitmap bitmap=drawingView.getMainbitmap();
            onEventsListener.OnSaveClicked(bitmap);
        }
    }
    private void initListenar(){
        onEventsListener=new OnEventsListener() {
            @Override
            public void OnRedClicked() {

            }

            @Override
            public void OnBlueClicked() {

            }

            @Override
            public void OnYellowClicked() {

            }

            @Override
            public void OnGreenClicked() {

            }

            @Override
            public void OnBlackClicked() {

            }

            @Override
            public void OnBrownClicked() {

            }

            @Override
            public void OnEraserClicked() {

            }

            @Override
            public void OnClearClicked() {

            }

            @Override
            public void OnBrushSizeClicked() {

            }

            @Override
            public void OnUndoClicked() {

            }

            @Override
            public void OnRedoclicked() {

            }

            @Override
            public void OnSaveClicked(Bitmap bitmap) {

            }
        };
    }
    public void setEvantListenar(OnEventsListener onEventsListener) {
        this.onEventsListener = onEventsListener;
    }
}
