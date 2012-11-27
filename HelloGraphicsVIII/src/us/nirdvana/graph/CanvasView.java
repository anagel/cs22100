package us.nirdvana.graph;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View {
			
	    Paint paint= new Paint();
	    
	    int  width, height;
	    int running = 0;
	    
	   protected ArrayList< ArrayList<Integer> > points = new ArrayList<ArrayList<Integer>>();
	        
		public CanvasView(Context context) {
		
			super(context);
		
			Display display =  ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
			width = display.getWidth();
			height = display.getHeight();
       
			paint.setColor(Color.WHITE);
			paint.setAntiAlias(true);
    }
			
		    @Override
		    public void onDraw(Canvas canvas) {
		            int i, j, bnd1, bnd2;
		            ArrayList<Integer> pSet = null;
		            
		            bnd1 = points.size();
		            
		            for(i=0; i< bnd1; i++)
		            {
		            	pSet = points.get(i);
		            	
		            	bnd2 = pSet.size();
		            	bnd2-=3;
		            	
		            	for(j=0; j<bnd2; j+=2)
		            	{
		            		canvas.drawLine(pSet.get(j), pSet.get(j+1), pSet.get(j+2), pSet.get(j+3), paint);
		            	}
		            }
		            
		           }
		    
		   

		    
		    @Override
		    public boolean onTouchEvent(MotionEvent e)
		    {
		    	 
		    	int size = 	e.getHistorySize();
		    	int i;
		    	
		    	ArrayList<Integer> tmpSet;
		    	
		    	if(e.getAction()== MotionEvent.ACTION_DOWN)
		    	{
		    		tmpSet = new ArrayList<Integer>();

			    	points.add(tmpSet);
		    	}
		    	else
		    	{
		    		tmpSet = points.get(points.size()-1);
		     	}
		    	
		    	Log.v("ONTOUCH", Integer.toString(e.getAction()));
		    	
		    	for(i=0; i<size; i++)
		    	{
		    		Log.v("ONTOUCH", e.getX(i) + " " + e.getY(i) );
		    		tmpSet.add((int)e.getHistoricalX(i));
		    		tmpSet.add((int)e.getHistoricalY(i));
		    	}
		    	
	    		tmpSet.add(   (int)  e.getX()  );
	    		tmpSet.add((int)e.getY());
		    	
		    	this.invalidate();
		    	return true;
		    }
		    
		    public void setHeight(int h)
		    {
		    	height = h;
		    }
		    public void setWidth(int w)
		    {
		    	width = w;
		    }

		    
			
}
