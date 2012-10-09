package andy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Mframe extends JFrame{
	
	JPanel cp = null, eastPane = null, centerPane = null;
	
	JComboBox<String> catList = null;
	JTextField fNameBox = null;
	JTextField lNameBox = null;
	JTextField ssnBox = null;
	JTextField addr1Box = null;
	JTextField addr2Box = null;
	JTextField cityBox = null;
	JTextField stateBox = null;
	JTextField zipBox = null;
	JTextField balanceBox = null;
	ButtonGroup regGroup = null;
	JRadioButton regStop = null;
	JRadioButton regClear = null;
	
	JButton newButton = null;
	JButton delButton = null;
	JButton findButton = null;
	JButton updateButton = null;
	
	public Mframe()
	{ 
		super("Student Records");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		String [] studentCats = {"Non-matriculated", "Undergraduate", "Graduate", "Postgraduate" };
		catList = new JComboBox<String>(studentCats);
		
	}

}
