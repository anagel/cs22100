import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements WindowListener {

	protected StudentPanel sPanel ;
	protected ControlPanel cPanel;
	
	MyFrame thisFrame;

	public MyFrame()  {
		// TODO Auto-generated constructor stub
		super();
		
		sPanel = new StudentPanel();
				cPanel = new ControlPanel(sPanel);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		add(sPanel);
		add(cPanel , BorderLayout.SOUTH);
		pack();
		setVisible(true);
		  
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			//cPanel.theStudents.writeToFile(ControlPanel.DATFILE);
			//cPanel.theStudents.toSerializedFile(ControlPanel.SERDATFILE);
			cPanel.theStudents.writeTextToNetwork();
		} catch (IOException ioEx) {
			JOptionPane.showMessageDialog(this, "Writing data to file failed!");
			ioEx.printStackTrace();
		}
		
		this.dispose();

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
