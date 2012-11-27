package us.nirdvana.thoughts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewThoughtActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	  super.onCreate(savedInstanceState);
      setContentView(R.layout.view); 
      
      Bundle b = getIntent().getExtras();
      
      TextView tag = (TextView) findViewById(R.id.viewTag);
      TextView thought = (TextView) findViewById(R.id.viewThought);
      
      tag.setText(b.getString("tag"));
      thought.setText(b.getString("thought"));
      
      
	}
	
	
}
