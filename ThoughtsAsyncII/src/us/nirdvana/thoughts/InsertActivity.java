package us.nirdvana.thoughts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends Activity {

	   EditText tag ;
	      EditText thought  ;
	      Context mContext;
	      Activity parent;
	      
	      
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	  super.onCreate(savedInstanceState);
      setContentView(R.layout.insert); 
    
      mContext = getApplicationContext();
      
    
      Button b = (Button) findViewById(R.id.submitButton);
       tag = (EditText) findViewById(R.id.tag);
       thought = (EditText) findViewById(R.id.thought);
      
      b.setOnClickListener( 
    		  new OnClickListener()
    		  {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				Thought t = new Thought();
				t.tag=	tag.getText().toString();
				t.thought = thought.getText().toString();
				
				DataModel.insert(t);
					
				
				Intent i = new Intent();
					 i.putExtra("thought", t);
					setResult(Activity.RESULT_OK, i);
				
					finish();
					
				}
    			  
    		  }
    		  );
      
      
	}
	
	
}
