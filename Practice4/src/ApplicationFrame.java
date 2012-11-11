import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame{

	JButton moveOnce;
	JButton start;
	JButton stop;
	ShapeOverlay layer;
	Thread animationThread;
	
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
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layer = new ShapeOverlay();
		
		Shape s1 = new Rectangle(5,5,25,100);
		Shape s2 = new Rectangle(200,100,25,25, Color.red, true);
		Shape s3 = new Rectangle(75,75,25,25,Color.blue, false);
		layer.add(s1);
		layer.add(s2);
		layer.add(s3);
		
		Shape s4 = new Circle(100, 100, 25, Color.cyan, true);
		Shape s5 = new Circle(100, 300, 25);
		layer.add(s4);
		layer.add(s5);
		
		JPanel p = new JPanel();
	 
		moveOnce = new JButton("Move Once");
		start= new JButton("Start");
		stop= new JButton("Stop");
		
		p.setLayout(new FlowLayout());
		p.add(moveOnce);
		p.add(start);
		p.add(stop);
	
		moveOnce.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layer.move();
			}
		});

		start.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(animationThread==null||!animationThread.isAlive())
						{ 
							layer.isRunning=true;
							animationThread = new Thread(layer);
							animationThread.start();
						}
					}
				}
				);
		
		stop.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						layer.isRunning=false;
						animationThread=null;
					}
				}
				);
		
		add( p, BorderLayout.SOUTH);
		add(layer);
		this.setVisible(true);
	}
}
