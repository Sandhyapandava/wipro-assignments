package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
 
 
 
 
class testSuiteHolder
{
	@Test
	void testAdd()
	{
		assertEquals(3, 3);
	}
 
 
	@Test
	void testAdd2()
	{
		assertEquals(3, 3);
	}
}
 
@Suite
@SelectClasses({
	testSuiteHolder.class
})
public class TestSuiteExample {
 
 
}