import org.junit.*;
import static org.junit.Assert.*;

public class LineTest {

	Line theLine;
	
	@Before
	public void setUp()
	{
		theLine = new LineImp();
	}
	
	@Test
	public void slopeTest()
	{
		theLine.setSlope(3.3);
		assertEquals(3.3, theLine.getSlope(), 0.0000001);
	}
	
	@Test
	public void interceptTest()
	{
	theLine.setIntercept(6.5);
	assertEquals(6.5, theLine.getIntercept(), 0.000001);
	}
	
	@Test
	public void deriveTest()
	{
	theLine.derive(0, 0, 1, 2);
	assertEquals(0, theLine.getIntercept(), 0.0000001);
	assertEquals(2, theLine.getSlope(), 0.0000001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deriveExTest()
	{
		theLine.derive(2, 1, 2, 10);
	}
	
}
