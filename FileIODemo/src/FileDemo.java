/*This Class demonstrates input and output, including with files.
 * Also, it handles some Exceptions.  Exceptions are raised by the 
 * JVM when something goes wrong, and the try/catch mechanism gives
 * us the chance to recover from errors gracefully.  Not handling Exceptions
 * will crash your program.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ifName = "input.txt";
		String ofName = "output.txt";
		File infile;
		File outfile;

		infile = new File(ifName);
		outfile = new File(ofName);
		
		String tmpStr;
		Scanner in;
		PrintWriter out;
			
		try {
			FileReader read =  new FileReader(infile);  //gets a character input stream from infile
			FileWriter outstream = new FileWriter(outfile); //gets a character output stream from outfile
															//if you open an output stream to a file that doesn't exist, it will be automatically created
			
			/* 
			 * System.in is an input stream from standard input.
			 * FileReader read is a character input stream coming from the file represented by infile.
			 * We could read from either directly, but they only provides relatively low level reading
			 * methods.  So, we wrap it in the Scanner class, which provides methods
			 * making it more convenient to get formatted input, like numbers.  But realistically, we want to make sure
			 * io operations are done efficiently with buffers, so we first wrap the FileReader in a BufferedReader.
			 * We wrap System.in in a BufferedInputStream since it's a byte based input stream as opposed to a character
			 * based input stream like FileReader.  The Scanner class can wrap either kind, so once we start using it,
			 * we don't have to worry about the difference between types of streams anymore.
			 * 
			 * Similarly, FileWriter opens a character output stream, but only provides relatively low
			 * level character write methods.  We will wrap it first in the BufferedWriter class, and that
			 *  in the PrintWriter class to make sure it's efficient and to get access to more convenient output methods.
			 * 
			 * This program will read numbers from whichever character stream you supply and stop
			 * when it finds the word 'exit'.  It skips strings that aren't numbers, but otherwise,
			 * prints them to the output file.
			 */
	
			//un-comment the next line and comment out the line after to make this program
			//use standard in instead of input.txt
			//	in = new Scanner(  new BufferedInputStream( System.in) );
			in = new Scanner( new BufferedReader(read)  );
			
			out = new PrintWriter( new BufferedWriter(outstream));
						
			int tmp = 0;
			
			tmpStr = in.next();  //reads until it hits whitespace and stores result in tmpStr
						
			while(  !tmpStr.startsWith("exit")   )
			{
				try
				{
				tmp = Integer.parseInt(tmpStr);  //try parsing as an int
					
				//if we got here, the number was good or execution would have skipped to the catch block
				System.out.println(tmp); //so we print to std out 
				out.println(tmp); //now we print to the output file
				
				tmpStr = in.next(); //get the next string
				}
				catch(NumberFormatException e)
				{
					e.printStackTrace();
					tmpStr = in.next();  //get the next string, we just skip the one that caused this exception
					continue;
				}
			}
			
			in.close();  //always remember to close input and output streams
			out.close(); //when we are using wrappers like this, closing the top level class 
						 //automatically closes the underlying streams we opened.
			}
			catch (FileNotFoundException e) {  //couldn't find a file, print the stacktrace, but then quit
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {  //a more generic IO error happened.  We print stack trace and quit
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}