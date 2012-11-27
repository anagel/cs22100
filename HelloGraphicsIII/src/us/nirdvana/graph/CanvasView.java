package us.nirdvana.graph;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

public class CanvasView extends View {
			
	        Paint paint= new Paint();
	        Drawable d;
	        
	public CanvasView(Context context) {
	
		super(context);
		
        Resources resc = context.getResources();
        d = resc.getDrawable(R.drawable.arrow1);
        
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }
			
		    @Override
		    public void onDraw(Canvas canvas) {
		    		paint.setColor(Color.WHITE);
		            canvas.drawCircle(20, 20, 20, paint);
		            paint.setColor(Color.RED);
		            canvas.drawText("Hello Circle", 20, 20, paint);
		            
		              d.setBounds(50, 50, 100, 100);
		              d.draw(canvas) ;
		           }

			
}
