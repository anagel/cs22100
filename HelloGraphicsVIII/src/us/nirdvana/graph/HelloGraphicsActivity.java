package us.nirdvana.graph;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
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
	 
	
	CanvasView mCanvas;
	 LinearLayout linear = null;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
  
        
        setContentView(R.layout.main);
         linear = (LinearLayout) findViewById(R.id.lin);
        mCanvas = new CanvasView(this);
        linear.addView(mCanvas);
        
        if( savedInstanceState != null && savedInstanceState.containsKey("size"))
        {
        	int size = savedInstanceState.getInt("size");
        	ArrayList<Integer> tmp;
        	int i;
        	for(i=0;i<size;i++)
        	{
        	tmp = savedInstanceState.getIntegerArrayList("arr"+i);
        	mCanvas.points.add(tmp);
        	}
        }
        
   /*      Object data =  getLastNonConfigurationInstance();
        if (data != null) {
        	Log.v("IN GET RETAINED", "asdf");
            mCanvas.points = (ArrayList<ArrayList<Integer>>) data;
        }*/

     
        	
        
    }  
    

    
    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    
    }
    
    @Override
    protected void onSaveInstanceState(Bundle b)
    {
    	int i, size;
    	size = mCanvas.points.size();
    	
    	
    	b.putInt("size", size);
    	
    	for(i=0;i<size;i++)
    	{
    	b.putIntegerArrayList("arr"+i, mCanvas.points.get(i));
    	}
    }
   
   
    
}