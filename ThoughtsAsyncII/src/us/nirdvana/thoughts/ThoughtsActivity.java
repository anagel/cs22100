package us.nirdvana.thoughts;

import java.util.ArrayList;


import android.app.Activity; 
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem; 
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter; 
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
 
public class ThoughtsActivity extends Activity {
	
	public static final int INSERT_RES_CODE = 1;
	 int mProgressStatus = 0;
	private ListView listView;
	private LinearLayout linear;
	 ArrayList<Thought> thoughtList;
	 ProgressBar mprogress;
	 Context mContext;
	 ArrayAdapter<String> adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  
        setContentView(R.layout.main); //set the layout from res/layouts/main.xml
        
        mContext = getApplicationContext();
        mprogress = (ProgressBar) findViewById(R.id.mprogress);
         listView = (ListView) findViewById(R.id.mylist);
      linear = (LinearLayout) findViewById(R.id.linear);
        listView.setTextFilterEnabled(true);  //makes list view filterable so if user types, only matches are shown in list
       
       
        new Thread(new Runnable() {
            public void run() {
                  
                thoughtList = DataModel.getThoughts(); //get arraylist of all thoughts
                 
                int listSize = thoughtList.size();  //Instantiate a String array and fill with the tags 
                int i;
               
                String[] values = new String[listSize];
                 
                for(i=0;i<listSize;i++)
                {
                	values[i] = thoughtList.get(i).tag;
                }
                 
                
                //Create an array adapter which will take items from our array and map to individual views that are inflated as user scrolls
                // First paramenter - Context
                // Second parameter - Layout for the row
                // Third parameter - ID of the View to which the data is written
                // Forth - the Array of data
                 adapter = new ArrayAdapter<String>(mContext,
                	android.R.layout.simple_list_item_1, android.R.id.text1, values);  

                // Assign adapter to ListView
               
            	
            	
            	
                    listView.post(new Runnable() {
                        public void run() {

                            linear.removeView(mprogress);
                            listView.setAdapter(adapter);  
                            
                       	
                        }
                    });
                
            }
        }).start();

        
        
 
        //Define how to respond to item clicks in list view
        listView.setOnItemClickListener(new OnItemClickListener() {
        	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

            	Intent i = new Intent (getApplicationContext(), ViewThoughtActivity.class);  //Create a new intent object, which we'll use to start a new activity
            
            	
            	Bundle b = new Bundle();  //we will use the bundle to package the data we want to send to the child activity
            	
            	Thought tmpThought = thoughtList.get(position);
            	b.putString("tag", tmpThought.tag);
            	b.putString("thought", tmpThought.thought);
            	
            	i.putExtras(b);  //we add the bundle to the intent
            	
            	startActivity(i);  //and we start the activity
            }

		
        });
        
      
    }
    
    @Override  //this method allows us to specify which xml file in the res/menu folder to inflate when user hits menu button
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }
    
    @Override  //This method is where we handle menu item selections
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    
    	switch (item.getItemId()) {
       
        case R.id.quit:
            finish();
            return true;
        case R.id.newThought:
        	 
        	Intent i = new Intent(getApplicationContext(), InsertActivity.class);
        	startActivityForResult( i, INSERT_RES_CODE );
            return true;
        default: 
            return super.onOptionsItemSelected(item);
        }
    }
    
    @Override //we override this method to handle responses from activities called using startActivityForResult()
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    
    	if(requestCode==INSERT_RES_CODE && resultCode == Activity.RESULT_OK)  //means that InsertActivity returned
    	{
        	//we kill this activity and restart it so onCreate() gets called again and the entire list, including piece just inserted will get displayed
    		//this is not an efficient solution, but it is simple.
            Thought t = (Thought) data.getSerializableExtra("thought");
            thoughtList.add(t);
            int listSize = thoughtList.size();  //Instantiate a String array and fill with the tags 
            int i;
           
            String[] values = new String[listSize];
             
            for(i=0;i<listSize;i++)
            {
            	values[i] = thoughtList.get(i).tag;
            }
             
            
            //Create an array adapter which will take items from our array and map to individual views that are inflated as user scrolls
            // First paramenter - Context
            // Second parameter - Layout for the row
            // Third parameter - ID of the View to which the data is written
            // Forth - the Array of data
             adapter = new ArrayAdapter<String>(mContext,
            	android.R.layout.simple_list_item_1, android.R.id.text1, values);  

            // Assign adapter to ListView
           
        	
        	
        	
                listView.post(new Runnable() {
                    public void run() {

                        linear.removeView(mprogress);
                        listView.setAdapter(adapter);  
                        
                   	
                    }
                });
        }
    }

    {
    	
    }
}