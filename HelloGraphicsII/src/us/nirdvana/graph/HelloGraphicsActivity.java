package us.nirdvana.graph;
 
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloGraphicsActivity extends Activity {
    /** Called when the activity is first created. */
	 
	 TextView prompt=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main);    
         
        Button button = (Button) findViewById(R.id.img_button);
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
		 		// TODO Auto-generated method stub
				prompt = (TextView) findViewById(R.id.prompt);
				prompt.setText("Been Clicked");
			} 
        	  
        });
    }  
}