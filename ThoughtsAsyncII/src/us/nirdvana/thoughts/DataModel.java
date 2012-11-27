package us.nirdvana.thoughts;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

 
public class DataModel {

private static final String DATA_URL = "http://www.nirdvana.us/thought.php";

public static boolean insert(Thought t)
{	  
	URL u = null;
	try {
		 u = new URL(DATA_URL);

			URLConnection c = u.openConnection();
			
			c.setDoOutput(true);
			
			OutputStreamWriter out = new OutputStreamWriter(c.getOutputStream());
			
			out.write("tag=");
			out.write( t.tag);
			out.write("&thought=");
			out.write(t.thought);
			out.close();
			
			BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    c.getInputStream()));
		String tStr = 	in.readLine();
		
		while(tStr!=null)
		{
			System.out.println(tStr);
			tStr = in.readLine();
		}
			in.close();
	
		 
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
		return false;

}

public static ArrayList<Thought> getThoughts()
{
	
	ArrayList<Thought> list = new ArrayList<Thought>();
	
	try {
	URLConnection conn =  (new URL(DATA_URL)).openConnection();
	
	
	String tmpStr;
	Thought tmpT;

	
	BufferedReader in;

		in = new BufferedReader(
		        new InputStreamReader(
		        conn.getInputStream()));
	
	
	tmpStr = in.readLine();
	while(tmpStr!=null)
	{
		 tmpT = new Thought();
		 try{
		tmpT.id = Integer.valueOf(tmpStr);
		 }
		 catch(NumberFormatException e)
			{
				break;
			}
			
		tmpStr = in.readLine();
		tmpT.tag = tmpStr;

		tmpStr = in.readLine();
		tmpT.thought = tmpStr;
		
		list.add(tmpT);
		
		tmpStr = in.readLine();
		
	}
	in.close();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return list;
}

}
