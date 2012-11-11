import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApplicationFrame extends JFrame {

	JButton submitButton;
	JTextField tField;
	JLabel resultText;
	
	public static void main(String[] args) {
	/** Create a Runnable object that will create our GUI objects
	 *  Then we use swing utilities to schedule that task in a thread safe way
	 */
		Runnable guiCreator = new Runnable(){

			@Override
			public void run() {
				/*
				 * Main was called statically, now we'll instanciate an
				 * object of the ApplicationFrame class.  This causes the constructor
				 * to be called, and the frame will be displayed.
				 */
				ApplicationFrame f = new ApplicationFrame();
			}
			
		};
		
		//now we use invokeLater to schedule the Runnable safely.
		javax.swing.SwingUtilities.invokeLater(guiCreator);
		
	}
	
	public ApplicationFrame()
	{
		super();
		setSize(300,300);
		setVisible(true);
		setBackground(Color.white);
		
		setLayout(new FlowLayout());
		
		submitButton = new JButton("submit");
		tField = new JTextField(10);
		resultText = new JLabel("Enter a value");
		add(tField);
		add(resultText);
		add(submitButton);
			
	}

}
