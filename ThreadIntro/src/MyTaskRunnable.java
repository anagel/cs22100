
public class MyTaskRunnable implements Runnable{

	String name;
	Object lock;
	
	public MyTaskRunnable(String name)
	{ 
	this.name = name;	
	}
	
	@Override 
	public void run()
	{
		int i;
		
		for(i=0;i<5;i++)
			System.out.println("Hello from "+ name + " " + i);
		
	}
	
}
