

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentPanel extends JPanel {
	
	Student stu;
	JLabel header;
	JLabel name;
	JLabel acct;
	JLabel balance;
	JLabel gpa;
	
	public StudentPanel()
	{
		super();
		this.setLayout(new GridLayout(0, 1));
		setBackground(Color.white);
		header = new JLabel("Current Student Info");
		header.setFont(new Font("Serif", Font.BOLD, 28));
		add(header);
		
		name= new JLabel("Name: ");
		name.setFont(new Font("Serif", Font.BOLD, 20));
		
		acct = new JLabel("Account Num: ");
		balance = new JLabel("Balance: ");
		gpa = new JLabel("GPA: ");
		
		add(name);
		add(acct);
		add(balance);
		add(gpa);
		
	}
	
	public void setStudent(Student s)
	{
		stu = s;
		name.setText("Name: "+stu.getName());
		acct.setText("Account Num: "+stu.getAccount());
		balance.setText("Balance: " + stu.getBalance());
		gpa.setText("GPA: "+stu.getGPA());
		validate();
	}
	
	
	
	
	


}
