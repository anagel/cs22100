package us.nirdvana.graph;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloGraphicsActivity extends Activity {
    /** Called when the activity is first created. */
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
       // setContentView(R.layout.main);
        
      //  LinearLayout v = (LinearLayout) findViewById(R.id.lin);
        CanvasView cview = new CanvasView(getApplicationContext());
      // 	v.addView(cview);
       	
       	setContentView(cview);
        
    }   
    
}