package com.gurudattdahare.paintview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gurudattdahare.paint.PaintView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   private example e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.red);
         e =findViewById(R.id.paintview);
       Button b2=findViewById(R.id.blue);
       Button b3=findViewById(R.id.green);
       Button b4=findViewById(R.id.yellow);
       Button b5=findViewById(R.id.black);
       Button b6=findViewById(R.id.eresor);
       Button b7 =findViewById(R.id.clear);
       Button b8=findViewById(R.id.size);
       b.setOnClickListener(this);
       b2.setOnClickListener(this);
       b3.setOnClickListener(this);
       b4.setOnClickListener(this);
       b5.setOnClickListener(this);
       b6.setOnClickListener(this);
       b7.setOnClickListener(this);
       b8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.red:
                e.red();
                break;
            case R.id.blue:
                e.blue();
                break;
            case R.id.green:
                e.green();
                break;
            case R.id.yellow:
                e.yellow();
                break;
            case R.id.black:
                e.black();
                break;
            case R.id.eresor:
                e.eresor();
                break;
            case  R.id.clear:
                e.clear();
                break;
                case R.id.size:
              e.Brown();
            break;
        }
    }
}