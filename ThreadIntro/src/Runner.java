
public class Runner {


public Runner()
{
	MyTaskRunnableNotify task1 = new MyTaskRunnableNotify("Task 1", this);
	Thread thread1 = new Thread(task1);
	
	//task1.name="Task 2";
	MyTaskRunnableNotify task2 = new MyTaskRunnableNotify("Task 2", this);
	Thread thread2 = new Thread(task2);

	//task1.name="Task 3";
	MyTaskRunnableNotify task3 = new MyTaskRunnableNotify("Task 3", this);
	Thread thread3 = new Thread(task3);

	synchronized(this)
	{
	thread1.start();
	try {
		wait();
		thread2.start();
		wait();
		
		thread3.start();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
}
