import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	ArrayList<Student> theStudents = new ArrayList<Student>();
	
	
	public void add(Student s)
	{
		theStudents.add(s);
	}
	
	public Student find(int acc)
	{
	int i, sz;
	sz = theStudents.size();
	for(i=0; i<sz; i++)
	{
		if(theStudents.get(i).getAccount()==acc)
		{
			return theStudents.get(i);
		}
	}
	return null;
	}
	
	public void writeToFile(String fileName) throws IOException
	{
		File file = new File(fileName);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		Student s;
		int i, cnt = theStudents.size();
		for(i=0; i<cnt; i++)
		{
			s = theStudents.get(i);
			out.println(s.getName());
			out.println(s.getAccount());
			out.println(s.getBalance());
			out.println(s.getGPA());
		}
		out.close();
		
	}
	
	public void readFromFile(String fileName) throws IOException
	{
		File file = new File(fileName);
		Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
		Student s;
		
		while(in.hasNext())
		{
			s = new Student();
			s.setName(in.nextLine());
			s.setAccount(in.nextInt());
			s.setBalance(in.nextDouble());
			s.setGPA(in.nextDouble());

			theStudents.add(s);
			in.nextLine();
		}
		in.close();
		
	}
	
	public void toSerializedFile(String fname) throws FileNotFoundException, IOException
	{
		File f = new File(fname);
		
		ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(f));
		
		out.writeObject(theStudents);
		out.close();
	}

	public void fromSerializedFile(String fname) throws FileNotFoundException, IOException
	{
		File f = new File(fname);
		
		if(!f.exists())
		{
			f.createNewFile();
		}
		
		ObjectInputStream out = new ObjectInputStream(
						new FileInputStream(f));
		
		try {
			theStudents = (ArrayList<Student>) out.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
	
	public void writeTextToNetwork() throws IOException
	{
		Socket clientSocket = null;
		String host = "127.0.0.1";
		int port = 10102;

		clientSocket = new Socket(host, port);  //create new socket connected to host on port 10101
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  //get output stream and wrap in PrintWriter for convenience
		
		out.println("w");
		out.flush();
		Student s;
		int i, cnt = theStudents.size();
		for(i=0; i<cnt; i++)
		{
			s = theStudents.get(i);
			out.println(s.getName());
			out.println(s.getAccount());
			out.println(s.getBalance());
			out.println(s.getGPA());
		}
		out.close();
		 
	}
	
	public void readTextFromNetwork() throws IOException
	{
		String host = "127.0.0.1";
		int port = 10102;
		Socket clientSocket = new Socket(host, port);  //create new socket connected to host on port 10101
		
		Scanner in = new Scanner( new BufferedReader(
				new InputStreamReader(
						clientSocket.getInputStream())));  //get socket input stream (and wrap in BuffereReader for efficiency, wrap in Scanner for convenience)

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  //get output stream and wrap in PrintWriter for convenience
		
		Student s;

		out.println("r");

		while(in.hasNext())
		{
			s = new Student();
			s.setName(in.nextLine());
			s.setAccount(in.nextInt());
			s.setBalance(in.nextDouble());
			s.setGPA(in.nextDouble());
			theStudents.add(s);
			in.nextLine();
		}
		
		in.close();
		out.close();
	}
}
