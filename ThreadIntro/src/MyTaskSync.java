
public class MyTaskSync extends Thread{

	String name;
	Object lock;
	
	public MyTaskSync(String name, Object o)
	{ 
		lock = o;
	this.name = name;	
	}
	
	@Override 
	public void run()
	{
		int i;
		
		synchronized(lock)
		{
		for(i=0;i<5;i++)
			System.out.println("Hello from "+ name + " " + i);
		}
	}
	
}
