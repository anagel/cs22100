import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class Shape {
	protected int x;  //the x and y coordinates where this shape should be drawn
	protected int y;
	protected Color color;
	protected boolean fill;
	protected int xMotion = 1;
	protected int yMotion = 3;
	
	abstract public void draw(Graphics g);
	abstract BoundingBox getBounds();
}
