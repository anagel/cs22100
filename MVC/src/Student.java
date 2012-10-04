import java.io.Serializable;
import java.util.InputMismatchException;


public class Student implements Serializable{
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = -7094608226042205823L;
	private String name;
	private int account;
	private double balance;
	private double gpa;
	
	public Student()
	{
		name = "";
		account = 0;
		balance = 0;
		gpa = 0;
	}
	
	public Student(String n, int acc, double bal, double gpa)
	{
		name = n; account = acc; balance = bal; this.gpa = gpa;
	}
	
	public Student(String n, int acc)
	{
		name = n; account = acc; balance = 0; gpa = 0;
	}
	
	public Student(String n, int acc, double bal)
	{
		name = n; account = acc; balance = bal; this.gpa = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getAccount()
	{
		return account;
	}
	
	public void setAccount(int n)
	{
		if(n < 0)
		{
			throw new InputMismatchException("Invalid range for Account Number");
		}
		account = n;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double bal)
	{
		balance = bal;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	public void setGPA(double gpa)
	{
		if(gpa<0 || gpa > 4)
		{
			throw new InputMismatchException("Invalid range for GPA");
		}
		this.gpa = gpa;
	}
}
