# PaintView:
PaintView is a custom View class which extends the View class.it's provide an area on screen for drawing.

![my screen](https://media.giphy.com/media/9ohxJxGbDbMsi47aVz/giphy.gif)
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
	        implementation 'com.github.GURUDATTDAHARE:PaintView:0.0.5'
	}
  ```
  ---
  3.implementation
  ---
   - add PaintView in your xml find and set an id.
   - add buttons under the paintView.here we can add maximum 8 buttons.
   - set click listener and call the methods of PaintView {Red(),Blue(),Yellow(),Green(),Black(),Ereser(),BrushSize(),ClearScreen()}
   ```xml
   xml: 
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
        app:layout_constraintTop_toTopOf="parent">

        <Button
            android:id="@+id/red"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#EE004B" />
            
   <!--   add other buttons  -->
        
  </com.gurudattdahare.paint.PaintView>
</androidx.constraintlayout.widget.ConstraintLayout>

   ```
   ---
   ---
   ```java
     Java code:
     
     public class MainActivity extends AppCompatActivity {
          private PaintView paintView;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView =findViewById(R.id.paintview);
        Button b=findViewById(R.id.red);
         b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               paintView.Red();
           }
       });
       
     // implement othe buttons   
    }
 }
        
   ```
   ---
