import org.junit.*;
import static org.junit.Assert.*;

public class AccTest {

	Account acc;
	static final double delta = 0.0000001;
	
	@Before
	public void setUp()
	{
		acc = new Account(2.3, 123);
	}
	
	@Test
	public void constructorTest()
	{
		assertEquals(123, acc.accountNum);
		assertEquals( 2.3, acc.getBalance(), delta);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void creditTest1()
	{
		acc.credit(-3);
	}
	
	@Test
	public void creditTest2()
	{
		acc.credit(3);
		assertEquals(5.3, acc.getBalance(), 0.0000001);
	}
	
	@Test
	public void debitTest()
	{
		assertTrue(  acc.debit(1)  );
		assertEquals(1.3, acc.getBalance(), 0.0000001);
	}
	
	@Test
	public void overdraftTest()
	{
		assertFalse(acc.debit(9));
		assertEquals(2.3, acc.getBalance(), 0.0000001);
	}
	
	
	
}
