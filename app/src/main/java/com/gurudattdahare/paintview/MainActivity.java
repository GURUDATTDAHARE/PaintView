package com.gurudattdahare.paintview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   private V paintView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView =findViewById(R.id.paintview);
        Button b=findViewById(R.id.red);
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
                paintView.Red();
                break;
            case R.id.blue:
                paintView.Blue();
                break;
            case R.id.green:
                paintView.Green();
                break;
            case R.id.yellow:
                paintView.Yellow();
                break;
            case R.id.black:
                paintView.Black();
                break;
            case R.id.eresor:
                paintView.Eresor();
                break;
            case  R.id.clear:
                paintView.ClearScreen();
                break;
                case R.id.size:
              paintView.BrushSize();
            break;
        }
    }
}