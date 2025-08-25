package junit;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
 
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
 
 
 
class add2Number
{
	int add2Num(int a,int b)
	{
		return a+b;
	}
}
 
 
class junit_example {
 
	@Test
	@DisplayName(" this demo testcase")
	@Disabled
	void test() {
		System.out.println("hello rk");
	}
	
	@Test
	@DisplayName(" assertEquals(actualValue, expectedValue) ")
	@Disabled
	void test2values()
	{
		int actualValue=5;
		int expectedValue=3;
		
		int unExpectedValue=3;
		//1--------->5,3
		assertEquals(actualValue, expectedValue);
		//2---------->3,3
		assertNotEquals(unExpectedValue, actualValue);
 
	}
	
	
	
	@Test
	@DisplayName("class 2 add number")
	void test2NumbersAdding()
	{
		
		add2Number add=new add2Number();
		int actualAddNumber =add.add2Num(2, 3);
		
		int excepetedValues=5;
		
		
		assertEquals(actualAddNumber, excepetedValues);
	}
	
	@Test
    @DisplayName(" xyz")
    void testAllDetails()
    {
    	String name="surya";
    	int age=25;
    	String city="Rjy";
    	
    	assertAll("User details xyz",
    			
    			()->assertEquals("surya", name),
    			()->assertTrue(age>24),
    			()->assertNotNull(city));
    	
    }
	@Test
    @DisplayName(" 123")
    void testDivideByzero()
    {
    	assertThrows(Exception.class,
    			()->
    	{
    		int result=10/0;
    	}
    	);
    	
    }
    
}
	
	