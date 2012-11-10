import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame{

	public static void main(String[] args) 
	{
		Runnable createGui = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ApplicationFrame f= new ApplicationFrame();
			}
		};
		javax.swing.SwingUtilities.invokeLater(createGui);
	}
	
	public ApplicationFrame()
	{
		super();
		this.setSize(400,400);
		this.setVisible(true);
		this.setBackground(Color.white);
		
		ShapeOverlay layer = new ShapeOverlay();
		
		Shape s1 = new Rectangle(5,5,25,100);
		Shape s2 = new Rectangle(200,100,25,25, Color.red, true);
		Shape s3 = new Rectangle(75,75,25,25,Color.blue, false);
		layer.add(s1);
		layer.add(s2);
		layer.add(s3);
		
		/*
		Shape s4 = new Circle(100, 100, 25, Color.cyan, true);
		Shape s5 = new Circle(100, 300, 25);
		layer.add(s4);
		layer.add(s5);
		*/
		
		add(layer);
	}
}
