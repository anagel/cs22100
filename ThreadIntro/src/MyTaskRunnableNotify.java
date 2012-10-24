
public class MyTaskRunnableNotify implements Runnable{

	String name;
	Object ringleader;
	
	public MyTaskRunnableNotify(String name, Object o)
	{ 
	this.name = name;	

	ringleader = o;
	}
	
	
	
	@Override 
	public void run()
	{
		int i;
		
		
		synchronized(ringleader)
		{
			for(i=0;i<5;i++)
				System.out.println("Hello from "+ name + " " + i);
			
			
		ringleader.notify();
		}
		
	}
	
}
