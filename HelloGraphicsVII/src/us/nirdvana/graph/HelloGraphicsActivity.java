package us.nirdvana.graph;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloGraphicsActivity extends Activity {
    /** Called when the activity is first created. */
	 
	Thread t=null;
	CanvasView mCanvas;
	 LinearLayout linear = null;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main);
         linear = (LinearLayout) findViewById(R.id.lin);
        mCanvas = new CanvasView(this);
        linear.addView(mCanvas);
     
        	
        
    }  
    

    
    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    
    }
    
    
   
    
}