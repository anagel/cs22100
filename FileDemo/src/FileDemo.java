import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//dir is a directory, tmp.txt is a regular file, you can see how this runs with both
		String fname = "D:/cs22100/work/FileDemo/dir";
	//	String fname = "tmp.txt";
		
		/*
		 * The File class gives us a way to easily handle files, get information about them, 
		 * and even, read directory information, since directories are really just a special kind of
		 * file.  There are many more methods available, but some of the functionality is
		 * demonstrated below.
		 */
		File file = new File(fname);
		
		if(file.exists())
		{
			System.out.println(fname+" exists.");
		}
		else
		{
			System.out.println(fname+" does not exist.");
		}
		
		if(file.isDirectory())
		{
			System.out.println(fname+" is  directory.");
		}
		else
		{
			System.out.println(fname+" is not a directory.");
		}
		
		if(file.canRead())
		{
			System.out.println(fname+" is readable.");
		}
		else
		{
			System.out.println(fname+" can not be read.");
		}
	
		
		File[] flist = file.listFiles();  //listFiles returns an array of File objects containing the directory contents
		
		int i;
		for(i=0;i<flist.length;i++)
		{
			System.out.println(flist[i].getName());
		}
			
	}

}

