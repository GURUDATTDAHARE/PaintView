package com.gurudattdahare.paintview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gurudattdahare.paint.EventManneger.OnEventsListener;
import com.gurudattdahare.paint.PaintView;


public class MainActivity extends AppCompatActivity {
   private PaintView paintView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintview);
//        paintView.setEvantListener(new OnEventsListener() {
//            @Override
//            public void OnRedClicked() {
//                Toast.makeText(getApplicationContext(),"red is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnBlueClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnYellowClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnGreenClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnBlackClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnBrownClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnEraserClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnClearClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnBrushSizeClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnUndoClicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnRedoclicked() {
//                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnSaveClicked(Bitmap bitmap) {
//                  // here you can save this bitmap as a .png format in your external storage.
//            }
//        });

    }


}