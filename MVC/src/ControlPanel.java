import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ControlPanel extends JPanel implements ActionListener{
	
	static final String DATFILE = "data.txt";
	static final String SERDATFILE = "data.ser";
	
	
	StudentPanel sPanel;
	StudentManager theStudents;
	JLabel nLab = new JLabel("Name: ");
	JLabel accLab = new JLabel("Account Num: ");
	JLabel balLab = new JLabel("Balance: ");
	JLabel gpaLab = new JLabel("GPA: ");
	JTextField nField = new JTextField(20);
	JTextField aField = new JTextField(20);
	JTextField bField = new JTextField(20);
	JTextField gField = new JTextField(20);
	
	JButton search = new JButton("Search");
	JButton update = new JButton("Update");
	JButton newStu = new JButton("Create");

	public ControlPanel(StudentPanel sPanel)
	{
		super();
		this.sPanel = sPanel;
		theStudents = new StudentManager();
		try {
		//	theStudents.readFromFile(DATFILE);
		//	theStudents.fromSerializedFile(SERDATFILE);
			theStudents.readTextFromNetwork();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Reading Data file failed");
			e.printStackTrace();
		}
		search.addActionListener(this);
		update.addActionListener(this);
		newStu.addActionListener(this);
		
		setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		add(search, c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy=0;
		add(update, c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy=0;
		add(newStu, c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(nLab, c);
		
		c = new GridBagConstraints();
		c.gridy=1;
		c.gridwidth = 2;
		add(nField, c);
		
		c = new GridBagConstraints();
		c.gridwidth=1;
		c.gridx=0;
		c.gridy=2;
		add(accLab, c);
		
		c = new GridBagConstraints();
		c.gridwidth=2;
		c.gridx=1;
		c.gridy=2;
		add(aField,c);
		
		c = new GridBagConstraints();
		c.gridwidth=1;
		c.gridx=0;
		c.gridy=3;
		add(balLab, c);
		
		c = new GridBagConstraints();
		c.gridy=3;
		c.gridwidth=2;
		c.gridx=1;
		add(bField,c);
		
		c = new GridBagConstraints();
		c.gridwidth=1;
		c.gridx=0;
		c.gridy=4;
		add(gpaLab, c);
		
		c = new GridBagConstraints();
		c.gridwidth=2;
		c.gridx=1;
		c.gridy=4;
		add(gField,c);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==newStu)
		{
			String n = nField.getText();
			String aStr = aField.getText();
			int a = Integer.parseInt(aStr);
			double b = Double.parseDouble(bField.getText());
			double g = Double.parseDouble(gField.getText());
			
			sPanel.setStudent(new Student(n, a, b, g));
			theStudents.add(sPanel.stu);
			
		}
		else if(e.getSource() == update)
		{
			String n = nField.getText();
			String aStr = aField.getText();
			int a = Integer.parseInt(aStr);
			double b = Double.parseDouble(bField.getText());
			double g = Double.parseDouble(gField.getText());
			
			Student s = theStudents.find(sPanel.stu.getAccount());
			s.setName(n);
			s.setAccount(a);
			s.setBalance(b);
			s.setGPA(g);
			sPanel.setStudent(s);
		}
		else if(e.getSource() == search)
		{
			String aStr = aField.getText();
			int a = Integer.parseInt(aStr);
			
			Student s = theStudents.find(a);
			sPanel.setStudent(s);
			
			aField.setText("");
			nField.setText("");
			bField.setText("");
			gField.setText("");
		}
	}

}
