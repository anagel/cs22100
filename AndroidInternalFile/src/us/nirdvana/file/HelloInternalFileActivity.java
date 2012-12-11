package us.nirdvana.file;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloInternalFileActivity extends Activity {
	
	EditText field; 
	Button clicker;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     
    	super.onCreate(savedInstanceState);
     
    	setContentView(R.layout.main2);
     
        
        field = (EditText) findViewById(R.id.field);
        clicker = (Button) findViewById(R.id.click);
          
        clicker.setOnClickListener(
        		new OnClickListener()
        				{
 
							@Override
							public void onClick(View arg0) {
								String FILENAME = "hello_file.txt";
								String string = "hello world!";
  
								try{
			 						//This is the android specific line 
									FileOutputStream ofStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
									
								PrintWriter outfile= new PrintWriter((ofStream), true);
							    outfile.println(field.getText());
							    outfile.close();
								
								}
								catch(FileNotFoundException e)
								{
									
								}
							}
        					
        				});
    }
}