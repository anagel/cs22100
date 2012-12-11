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

public class HelloExternalFileActivityII extends Activity {
	 
	EditText field; 
	Button clicker;
	File storage;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        field = (EditText) findViewById(R.id.field); 
        clicker = (Button) findViewById(R.id.click);
        storage = getExternalFilesDir(null);
        clicker.setOnClickListener(
        		new OnClickListener()
        				{
 
							@Override
							public void onClick(View arg0) {
											
								//First we must check to make sure public storage is available and mounted
								String state = Environment.getExternalStorageState();
								
								if (Environment.MEDIA_MOUNTED.equals(state)) { 
								
								//calling getExternalFilesDir from this activity context gets a directory
								//where our files will be private.  Anything we put here will be automatically 
								//deleted if the user uninstalls the app
								File file = new File( getExternalFilesDir(null), "DemoFile.txt");
								
								try{
									
								PrintWriter outfile= new PrintWriter((new FileOutputStream(file)), true);
							    outfile.println(field.getText());
							    outfile.close();
							    
								}
								catch(FileNotFoundException e)
								{
									e.printStackTrace();
								}   
								
								//Calling Evironment.getExternalStorageDirectory() returns the root of
								//the public storage directory.  We should create a subfolder so we don't
								//clutter up the top level of the user's storage space.  Any files we save or
								//create here will persist until the user explicitly deletes them or our code
								//explicitly deletes them.  Uninstalling the app will not affect these files.
								file = new File(Environment.getExternalStorageDirectory(), "HelloExternalFile");
								
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