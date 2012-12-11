import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

public class Circle extends Shape{

	protected int diameter;
	
	public Circle(int x, int y, int diameter)
	{
		this.diameter = diameter;
		this.x = x;
		this.y = y;
		this.color = Color.black;
		this.fill = false;
	}
	
	public Circle(int x, int y, int diameter, Color color, boolean fill)
	{
		this.diameter = diameter;
		this.x = x;
		this.y = y;
		this.color = color;
		this.fill = fill;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Color saved = g.getColor();
		g.setColor(color);
		if(fill)
			g.fillOval(x, y, diameter, diameter);
		else
			g.drawOval(x, y, diameter, diameter);
		
		g.setColor(saved);
	}
}
