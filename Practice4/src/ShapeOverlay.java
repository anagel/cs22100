import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapeOverlay extends JPanel implements Runnable{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	boolean isRunning = false;
	
	@Override
	public void paintComponent(Graphics g)
	{
		int i, sz=shapes.size();
		for(i=0;i<sz;i++)
		{
			shapes.get(i).draw(g);
		}
	}
	
	public void add(Shape s)
	{
		shapes.add(s);
	}
	
	public void move()
	{
		Dimension frameSize =getSize();
		int i, sz = shapes.size();
		Shape tmp;
		for(i=0;i<sz;i++)
		{
			tmp = shapes.get(i);
			

			if(tmp.xMotion > 0)
			{
				if(tmp.getClass()==Rectangle.class)
				{
					if(tmp.x + ((Rectangle) tmp).width>frameSize.width)
					{
						tmp.xMotion*=-1;
					}
				}
				else if(tmp.getClass()==Circle.class)
					{
						if(tmp.x + ((Circle) tmp).diameter>frameSize.width)
						{
							tmp.xMotion*=-1;
						}
					}
			}
			else
			{
					if(tmp.x < 1)
					{
						tmp.xMotion*=-1;
					}
			}
			
			if(tmp.yMotion > 0)
			{
				if(tmp.getClass()==Rectangle.class)
				{
					if(tmp.y + ((Rectangle) tmp).height>frameSize.height)
					{
						tmp.yMotion*=-1;
					}
				}
				else if(tmp.getClass()==Circle.class)
				{
					if(tmp.y + ((Circle) tmp).diameter>frameSize.height)
					{
						tmp.yMotion*=-1;
					}
				}
			}
			else
			{
					if(tmp.y < 1)
					{
						tmp.yMotion*=-1;
					}
			}
			
			Graphics g = getGraphics();
			getComponentGraphics(g);
			
			Color oldShapeColor = tmp.color;
			Color eraseColor = getBackground();
			tmp.color = eraseColor;
			tmp.draw(g);
			tmp.y += tmp.yMotion;
			tmp.x += tmp.xMotion;
			tmp.color = oldShapeColor;
			tmp.draw(g);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long t1=0, t2=30;
		long waitTime = 20;		long waitTimeLeft = 20;
		boolean waitedEnough = true;
	while(isRunning)
	{
		if(waitedEnough)
		{
		t1 = System.currentTimeMillis();
		waitTimeLeft = waitTime;
		}
		else
		{
			waitTimeLeft = waitTime - (t2-t1);
		}
		

		
		try{
			Thread.sleep(waitTimeLeft);
		}
		catch(InterruptedException e)
		{
			
		}
		t2=System.currentTimeMillis();
		if(t2-t1>=waitTime)
		{
			waitedEnough = true;
			move();
		}
		else
			waitedEnough = false;
		
	}
	}	
	
}
