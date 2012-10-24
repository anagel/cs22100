
public class Account {

	public final double INTEREST_RATE = 0.035;
	public int accountNum;
	protected double balance;

	
	public Account()
	{
		
	}
	
	public Account(double startingBalance, int accNum)
	{
	//	INTEREST_RATE = 0.035;
		accountNum = accNum;
		balance = startingBalance;
		
	}
	
	public Account(int accNum) {
	//	INTEREST_RATE = 0.035;
		accountNum = accNum;
		balance =  0.0;
		
	}
	
	public void merge(Account a)
	{
		balance = balance + a.balance;
		a.balance = 0;
		
	}
	
	public void payInterest()
	{
		balance = INTEREST_RATE*balance + balance;
	}
	

	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double newBalance)
	{
		if(newBalance > 0)
		 balance= newBalance;
		else
			balance = 0;
	}
	
	public double credit(double money) throws IllegalArgumentException
	{
		if(money<0)
		{
			IllegalArgumentException e = new IllegalArgumentException("money must be non-negative");
			//throw e;
		}
		
		balance += money;
		return balance;
	}
	
	
	public boolean debit(double money)
	{
		if( balance >= money)
		{
			balance -= money;
			return true;
		}
		return false;
	}
	
}
