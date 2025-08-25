package junit;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ex2 {
	
	class numberCheck{
		 boolean Check(int a) {
			if(a%2==0) {
				return true;
			}else {
				return false;
			}
		}
	}
	@Test
	@DisplayName("class number check")
	void testNum() {
		numberCheck nc=new numberCheck();
		System.out.println(nc.Check(20));
		assertTrue(nc.Check(20));
//		assertFalse(nc.Check(19));
		
	}
	@BeforeAll
	static void msg() {
		System.out.println("started the testing");
	}
	@ParameterizedTest
	@ValueSource(ints = {2,4,6,8,10,12})
	void testEvenNumber(int number)
	{
		assertTrue(number%2==0);
		
	}
	@ParameterizedTest
	@CsvSource({ "2,3,5", "2,6,8", "3,9,12" })
	void testAddition(int a, int b, int result) {
		assertEquals(result, a + b);
	}
	
	
}