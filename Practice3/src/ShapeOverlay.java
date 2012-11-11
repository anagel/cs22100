import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapeOverlay extends JPanel {

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
			
			Color oldGraphics = g.getColor();
			Color oldShape = tmp.color;
			Color c = getBackground();
			g.setColor(c);
			tmp.color = c;
			tmp.draw(g);
			tmp.y += tmp.yMotion;
			tmp.x += tmp.xMotion;
			g.setColor(oldGraphics);
			tmp.color = oldShape;
			tmp.draw(g);
		}
	}

	
	
}
