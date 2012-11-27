package us.nirdvana.graph;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View implements Runnable{
			
	    Paint paint= new Paint();
	    
	    int x, y, width, height;
	    int running = 0;
	        
		public CanvasView(Context context) {
		
			super(context);
		
			Display display =  ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
			width = display.getWidth();
			height = display.getHeight();

			x=50;
			y=50;
       
			paint.setColor(Color.WHITE);
			paint.setAntiAlias(true);
    }
			
		    @Override
		    public void onDraw(Canvas canvas) {
		            canvas.drawCircle(x, y, 20, paint);
		            
		           }

		    public void quit()
		    {
		    	running = 1;
		    }
			
		    
		    @Override
			public void run() {
				// TODO Auto-generated method stub
				
				int xmotion = 1, ymotion=1;
				while(running == 0)
					{
					Log.d("RUN:", "In run");
					
				x += xmotion;
					y += ymotion;
				
					if(x<0 || x>=width)
					{
						xmotion*=-1;
					}
					if(y<0 || y>=height)
					{
						ymotion*=-1;
					}
				
					synchronized(this){
						
					try
					{
						wait(30);
					}
					catch(InterruptedException e)
					{
					
					}
					}//end synchronized block 
					this.postInvalidate();
					} //end while loop
		    	}
		    
		    @Override
		    public boolean onTouchEvent(MotionEvent e)
		    {
		    	synchronized(this){
		    	
		    	x = (int)e.getX();
		    	y = (int)e.getY();
		    	}
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
