import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;


public class Rectangle extends Shape{

	protected int width, height;
	
	public Rectangle(int x, int y, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = Color.black;
		this.fill = false;
	}
	
	public Rectangle(int x, int y, int width, int height, Color color, boolean fill)
	{
		this.width = width;
		this.height = height;
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
			g.fillRect(x, y, width, height);
		else
			g.drawRect(x, y, width, height);
		g.setColor(saved);
	}
	
	@Override
	BoundingBox getBounds() {
		// TODO Auto-generated method stub
	
		return null;
	}
}
