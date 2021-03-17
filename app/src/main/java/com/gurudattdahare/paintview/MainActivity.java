package com.gurudattdahare.paintview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gurudattdahare.paint.EventManneger.OnEventsListener;
import com.gurudattdahare.paint.PaintView;


public class MainActivity extends AppCompatActivity {
   private PaintView paintView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintview);
        paintView.setEvantListenar(new OnEventsListener() {
            @Override
            public void OnRedClicked() {
 Toast.makeText(getApplicationContext(),"red .",Toast.LENGTH_SHORT).show();
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
        });

    }


}