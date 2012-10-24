
public class MyTaskRunnableSync implements Runnable{

	String name;
	Object lock;
	
	public MyTaskRunnableSync(String name, Object o)
	{ 
	this.name = name;	
	lock = o;
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
