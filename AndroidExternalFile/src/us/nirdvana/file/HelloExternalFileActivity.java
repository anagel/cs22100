package us.nirdvana.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloExternalFileActivity extends Activity {
	
	EditText field; 
	Button clicker;
	Context ctx; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        field = (EditText) findViewById(R.id.field);
        clicker = (Button) findViewById(R.id.click);
        ctx = getApplicationContext();
        clicker.setOnClickListener(
        		new OnClickListener()
        				{
 
							@Override
							public void onClick(View arg0) {
																
								String state = Environment.getExternalStorageState();
								
								if (Environment.MEDIA_MOUNTED.equals(state)) { 

									//Calling this gives us a publicly readable directory, and files we put there
									//will persist if the app is uninstalled
								 	File file = new File(Environment.getExternalStorageDirectory(), "HelloExternalFile");
									
									file.mkdir(); 
									File file2 = new File(file, "data.txt");
									try
									{
										PrintWriter outfile= new PrintWriter((new FileOutputStream(file2, true)), true);
									    outfile.println(field.getText());
								 	    outfile.close();
									}
									catch(FileNotFoundException e)
									{
										e.printStackTrace();
									}
									
								
									
									
								}
							}
        					
        				});
    }
    
   
}