package com.example.androidasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	ProgressDialog progLog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//Method 1, simple progress dialog with indefinite progress updates
	/*
	 	progLog = ProgressDialog.show(this, "My Progress", "Wasting time...");
		MyTask task = new MyTask();
	*/
		
		
	/*	progLog = new ProgressDialog(this);
		progLog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progLog.setTitle("Our Progress Title:");
		progLog.setMessage("Doing the long task, please wait.");
		progLog.setCancelable( true );
		progLog.show();
		MyTaskWithProgress task2 = new MyTaskWithProgress();
		task2.execute((Void[])null);
		*/
		
		progLog = new ProgressDialog(this);
		progLog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progLog.setTitle("Our Progress Title:");
		progLog.setMessage("Doing the long task, please wait.");
		progLog.setCancelable( true );
	
		final MyCancelableTaskWithProgress task3 = new MyCancelableTaskWithProgress();
		
		progLog.setOnCancelListener(new OnCancelListener(){

			@Override
			public void onCancel(DialogInterface arg0) {
				task3.cancel(true);
			}
			
		});
		
		progLog.show();
		task3.execute(500);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public class MyTask extends AsyncTask<Void, Void, Void>
	{
		@Override
		protected Void doInBackground(Void... arg0) {
			 
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		
			
			//If we do something like below, the app might crash since we're
			//altering the UI from a background thread.  This is why the 
			//onPostExecute method exists, it will automatically be run on the UI thread,
			//and that's where we should be putting code that updates the UI
		/*
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			t.setText("Finished!");
		*/	
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void v)
		{
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			t.setText("Finished!");
		}
		
	}
	
	public class MyTaskWithProgress extends AsyncTask<Void, Integer, Void>
	{
		@Override
		protected Void doInBackground(Void... arg0) {
			 
			int i;
			for(i=0;i<10;i++)
			{
				try
				{
					Thread.sleep(300);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				publishProgress((int)((i+1)/10.0 * 100));
			}
			
		
			
			//If we do something like below, the app might crash since we're
			//altering the UI from a background thread.  This is why the 
			//onPostExecute method exists, it will automatically be run on the UI thread,
			//and that's where we should be putting code that updates the UI
		/*
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			t.setText("Finished!");
		*/	
			
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Integer ... progress)
		{
			progLog.setProgress(progress[0]);
		}
		
		@Override
		protected void onPostExecute(Void v)
		{
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			t.setText("Finished!");
		}
		
	}
	
	public class MyCancelableTaskWithProgress extends AsyncTask<Integer, Integer, Boolean>
	{
		@Override
		protected Boolean doInBackground(Integer... arg0) {
			 
			int i;
			for(i=0;i<10;i++)
			{

				Long t1 = System.currentTimeMillis();
				Long t2 = System.currentTimeMillis();
				while(t2-t1<arg0[0])
				{
					t2 = System.currentTimeMillis();
				}
				publishProgress((int)((i+1)/10.0 * 100));
				if(isCancelled())
					return false;
			}
			
		
			
			//If we do something like below, the app might crash since we're
			//altering the UI from a background thread.  This is why the 
			//onPostExecute method exists, it will automatically be run on the UI thread,
			//and that's where we should be putting code that updates the UI
		/*
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			t.setText("Finished!");
		*/	
			
			return true;
		}
		
		@Override
		protected void onProgressUpdate(Integer ... progress)
		{
			progLog.setProgress(progress[0]);
		}
		
		@Override
		protected void onPostExecute(Boolean b)
		{
		    progLog.dismiss();
			TextView t = (TextView) findViewById(R.id.tv);
			
			if(b)
			t.setText("Finished!");
			else
				t.setText("On Post Execute: Got canceled Early");
		}
		
	}
}
