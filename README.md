# PaintView:[![](https://jitpack.io/v/GURUDATTDAHARE/PaintView.svg)](https://jitpack.io/#GURUDATTDAHARE/PaintView)


PaintView is a custom View class which extends the View class.it's provide an area on screen for drawing.

![my screen](https://media.giphy.com/media/h9owDgxPfoBmxgXKbO/giphy.gif)  ![my screen](https://media.giphy.com/media/6duWCHAuDl3xqsx9d1/giphy.gif) 


# How to use:
1.Add repositories
---
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  ---
  2.Add dependencies
  ---
  ```
  dependencies {
	        implementation 'com.github.GURUDATTDAHARE:PaintView:0.0.9'
	}
  ```
  ---
  3.implementation
  ---
   - add PaintView in your xml find and set an id.
   ```xml
  <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    
        <com.gurudattdahare.paint.PaintView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
            android:id="@+id/paintview"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
            >
    </com.gurudattdahare.paint.PaintView>
</androidx.constraintlayout.widget.ConstraintLayout>
   ```
   ---
   ---
   - if you want to do some extra things when buttons are clicked  then you neet to implement OnEventListener.
   ```java
     Java code:
     
     public class MainActivity extends AppCompatActivity {
   private PaintView paintView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintview);
        paintView.setEvantListenar(new OnEventsListener() {
            @Override
            public void OnRedClicked() {
                Toast.makeText(getApplicationContext(),"red is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnBlueClicked() {
                Toast.makeText(getApplicationContext(),"blue is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnYellowClicked() {
                Toast.makeText(getApplicationContext(),"yellow is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnGreenClicked() {
                Toast.makeText(getApplicationContext(),"green is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnBlackClicked() {
                Toast.makeText(getApplicationContext(),"black is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnBrownClicked() {
                Toast.makeText(getApplicationContext(),"brown is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnEraserClicked() {
                Toast.makeText(getApplicationContext(),"eraser is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnClearClicked() {
                Toast.makeText(getApplicationContext(),"clear screen is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnBrushSizeClicked() {
                Toast.makeText(getApplicationContext(),"brush size button is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnUndoClicked() {
                Toast.makeText(getApplicationContext(),"undo button is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnRedoclicked() {
                Toast.makeText(getApplicationContext(),"redo button is clicked.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnSaveClicked(Bitmap bitmap) {
                  // here you can save this bitmap as a .png format in your external storage.
            }
        });

    }


}
        
   ```
   ---
