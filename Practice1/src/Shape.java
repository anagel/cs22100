import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class Shape {
	protected int x;  //the x and y coordinates where this shape should be drawn
	protected int y;
	protected Color color;
	protected boolean fill;
	
	abstract public void draw(Graphics g);
}
