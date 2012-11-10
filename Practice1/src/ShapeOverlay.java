import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class ShapeOverlay extends JPanel{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	@Override
	public void paintComponent(Graphics g)
	{
		int i, sz=shapes.size();
		for(i=0;i<sz;i++)
		{
			shapes.get(i).draw(g);
		}
		
		g.fill3DRect(200, 200, 30, 30, true);
	}
	
	public void add(Shape s)
	{
		shapes.add(s);
	}
	
	
	
	
}
