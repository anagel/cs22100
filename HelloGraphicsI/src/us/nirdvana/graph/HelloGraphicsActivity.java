package us.nirdvana.graph;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class HelloGraphicsActivity extends Activity {
    /** Called when the activity is first created. */
	
 
  	 TransitionDrawable transition=null;
	
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main);    

        Resources res = this.getResources();
          transition = (TransitionDrawable) res.getDrawable(R.drawable.arrows);
        
        ImageView image = (ImageView) findViewById(R.id.trans);
        image.setImageDrawable(transition);
        image.setOnClickListener(
        		new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						transition.startTransition(2000);

					}
        			
        		});
         
				// TODO Auto-generated method stub
					
				
        	
    }  
}